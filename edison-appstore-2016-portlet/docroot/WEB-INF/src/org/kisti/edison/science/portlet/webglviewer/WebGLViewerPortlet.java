package org.kisti.edison.science.portlet.webglviewer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import net.sf.json.JSONException;
import net.sf.json.JSONSerializer;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.kisti.edison.model.EdisonExpando;
import org.kisti.edison.model.EdisonMessageConstants;
import org.kisti.edison.model.IcebreakerVcToken;
import org.kisti.edison.util.CustomUtil;
import org.kisti.edison.util.IcebreakerUtil;
import org.kisti.edison.util.RequestUtil;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.User;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class WebGLViewerPortlet
 */
public class WebGLViewerPortlet extends MVCPortlet
{
	@SuppressWarnings("rawtypes")
	@Override
	public void doView(RenderRequest request, RenderResponse response) throws IOException, PortletException 
	{
//		String portletId = (String) request.getAttribute(WebKeys.PORTLET_ID);
//		System.err.println(portletId);
		try 
		{
			Map param = RequestUtil.getParameterMap(request);
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			User user = themeDisplay.getUser();
			
			long groupId = Long.parseLong(CustomUtil.strNull(param.get("groupId"), String.valueOf(PortalUtil.getScopeGroupId(request))));
			Group thisGroup = GroupLocalServiceUtil.getGroup(groupId);

			String fileListType = CustomUtil.strNull(param.get("fileListType"));
			String fileListValue = CustomUtil.strNull(param.get("fileListValue"));
			String jobUuid = CustomUtil.strNull(param.get("jobUuid"));
			String icebreakerUrl = CustomUtil.strNull(thisGroup.getExpandoBridge().getAttribute(EdisonExpando.SITE_ICEBREAKER_URL));
			
			//Test용
			//jobUuid = "ccf1c0c1-ae37-49fc-81e1-229199a8337b";
			
			IcebreakerVcToken icebreakerVcToken = IcebreakerUtil.getIceBreakerToken(user, groupId, thisGroup, themeDisplay);
			
			String dirPath = "result";
			if(fileListType.equals("FOLDER"))
				dirPath = fileListValue;
			else if(fileListType.equals("TEMP"))
				dirPath = "";
			
			String result = IcebreakerUtil.getSimulationResult(icebreakerUrl, icebreakerVcToken.getVcToken(), jobUuid, dirPath);
			if (!CustomUtil.strNull(result).equals("")) 
			{
				JSONObject jsonObj = JSONObject.fromObject(JSONSerializer.toJSON(result));
				JSONArray jsonArray = jsonObj.getJSONArray("files");
				
				String resultFilePath = getResultFilePath(icebreakerUrl, icebreakerVcToken.getVcToken() , jobUuid, "result.zip");
				request.setAttribute("icebreakerUrl",icebreakerUrl);
				request.setAttribute("resultDataList", IcebreakerUtil.sortJsonArray(jsonArray, fileListType,fileListValue,"name").toString());
				request.setAttribute("resultFilePath", resultFilePath);
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			SessionErrors.add(request, EdisonMessageConstants.SEARCH_ERROR);
		}
		super.doView(request, response);
	}
	
	/**
	 * webgl을 위한 파일 생성 후 url 리턴(임시 사용-추후 수정 예정)
	 * @param params
	 * @throws IOException 
	 * @throws JSONException 
	 */
	@SuppressWarnings("resource")
	public String getResultFilePath(String icebreakerUrl, String vcToken, String jobUuid, String fileName) throws IOException
	{
		String filePath = System.getProperty("catalina.home")+"/webapps/data/webgl_temp/"+jobUuid;
		
		//uuid로 폴더 생성
		File resultFolder = new File(filePath);
		if( !resultFolder.exists() )
		{
			resultFolder.mkdirs();
		}
		
		//result.zip을 만들 폴더 생성
		resultFolder = new File(filePath+"/result");
		if( !resultFolder.exists() )
		{
			resultFolder.mkdirs();
		}
		
		File resultFile = new File(filePath+ File.separator+fileName);
		
		if(!resultFile.exists())
		{
			// 임시 : Result.zip File ID
			String resultFileStr = IcebreakerUtil.getSimulationResult(icebreakerUrl, vcToken, jobUuid, "/");
			String zipFileId="";
			try
			{
				if (!CustomUtil.strNull(resultFileStr).equals("")) {
					JSONObject jsonObj = JSONObject.fromObject(JSONSerializer.toJSON(resultFileStr));
					JSONArray jsonArray = jsonObj.getJSONArray("files");
					
					root1:for (int i = 0; i < jsonArray.size(); i++) {
						JSONObject comandObj = (JSONObject) jsonArray.get(i);
						if( comandObj.getString("name").equals("result.zip")){
							zipFileId = comandObj.getString("id");
							break root1;
						}
					}
				}
			}	
			catch (JSONException e) 
			{
				e.printStackTrace();
			}
			
			File tempZipFile = null;
			
			if(!CustomUtil.strNull(vcToken).equals("")){
				URL url = new URL(icebreakerUrl+"/api/file/download?id="+CustomUtil.strNull(zipFileId));
				
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				
				conn.setDoOutput(true);
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "text/plain");
				conn.setRequestProperty("Content-Type", "application/xml");

				//파일 생성 체크, 없을 시에 IB로부터 받아와 임시로 생성
				tempZipFile = new File(filePath+File.separator+fileName);
				if(!tempZipFile.exists())
				{
					if (conn.getResponseCode() == 200) 
					{
						InputStream inputStream = conn.getInputStream();
						FileOutputStream outputStream = new FileOutputStream( filePath+"/"+fileName );
	
					    int BUFFER_SIZE = 4096;
					    int bytesRead = -1;
					    byte[] buffer = new byte[BUFFER_SIZE];
					    while ((bytesRead = inputStream.read(buffer)) != -1) {
					    	outputStream.write(buffer, 0, bytesRead);
					    }
					    inputStream.close();
					}else if (conn.getResponseCode() == 400) {
						System.out.println("Failed IcebreakerService [ getFilePath ] : BAD REQUEST : wrong body content - HTTP error code : " + conn.getResponseCode());		
					}else if (conn.getResponseCode() == 413) {
						System.out.println("Failed IcebreakerService [ getFilePath ] : REQUEST ENTITY TO LARGE : 10MBytes Limit - HTTP error code : " + conn.getResponseCode());		
					}else{			
						System.out.println("Failed IcebreakerService [ getFilePath ] : ETC : etc error - HTTP error code : " + conn.getResponseCode());
					}
				}
				
				conn.disconnect();		
				
				if(tempZipFile.exists())
				{
					// Extract result.zip
					ZipInputStream zis = new ZipInputStream(new FileInputStream(tempZipFile));
					ZipEntry ze = zis.getNextEntry();
					byte[] buffer = new byte[1024];
					
					while(ze!=null)
					{
				            String entryfileName = ze.getName();
				            
				            File newFile = null;
				            
				            if (ze.isDirectory()) {
				            	newFile = new File(filePath+File.separator + entryfileName);
				                newFile.mkdirs();
				            } 
				            else 
				            {
				            	FileOutputStream fos = null;
				            	
				            	// ze가 디렉터리 임에도 ze.isDirectory()가 오동작, 따라서 result 폴더를 만들어준다.
				            	newFile = new File(filePath+File.separator + entryfileName);
				            	fos = new FileOutputStream(newFile);

				            	int len;
				                while ((len = zis.read(buffer)) > 0) 
				                {
				                    fos.write(buffer, 0, len);
				                }
				                fos.close();
				            }
				            ze = zis.getNextEntry();
				            newFile.deleteOnExit();
					}
				    	
					tempZipFile.deleteOnExit();
			        zis.closeEntry();
			    	zis.close();
			    		
			    	System.out.println("["+jobUuid+"]UNZIP Done");
				}else{
					System.out.println("Failed IcebreakerService [ getFilePath ] : Token is NOT NULL - Request error code : 999");
				}
			}
		}
		return jobUuid+ "/result/";
	}
}