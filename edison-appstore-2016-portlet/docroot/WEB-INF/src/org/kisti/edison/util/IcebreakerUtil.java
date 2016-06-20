package org.kisti.edison.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.kisti.edison.model.EdisonExpando;
import org.kisti.edison.model.EdisonRoleConstants;
import org.kisti.edison.model.IcebreakerVcToken;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.expando.model.ExpandoColumn;
import com.liferay.portlet.expando.model.ExpandoTableConstants;
import com.liferay.portlet.expando.service.ExpandoColumnLocalServiceUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

public class IcebreakerUtil 
{
	private static Log log = LogFactoryUtil.getLog(IcebreakerUtil.class);
	public static IcebreakerVcToken createExpandoUserVctoken(User user, long thisGroupId, String userScreenName, String userPassword) throws SystemException, MalformedURLException, PortalException, IOException, ParseException {

		IcebreakerVcToken icebreakerVcToken = new IcebreakerVcToken();
		
		//icebreaker 가입이 성공한 경우 신규 토큰 발행 및 커스텀 필드 추가
		icebreakerVcToken = TokenProviderUtil.getVcToken(thisGroupId, userScreenName, userPassword);										
		icebreakerVcToken.setVcToken(icebreakerVcToken.getVcToken());					
		icebreakerVcToken.setVcTokenExpired(icebreakerVcToken.getVcTokenExpired());
		
		if(!user.getExpandoBridge().hasAttribute(EdisonExpando.USER_VC_TOKEN + String.valueOf(thisGroupId))){		

			user.getExpandoBridge().addAttribute(EdisonExpando.USER_VC_TOKEN + String.valueOf(thisGroupId), false);
			user.getExpandoBridge().addAttribute(EdisonExpando.USER_VC_TOKEN_EXPIRED + String.valueOf(thisGroupId), false);
			
			ExpandoColumn toKenColumn = ExpandoColumnLocalServiceUtil.getColumn(
																			user.getExpandoBridge().getCompanyId(), 
																			user.getExpandoBridge().getClassName(), 
																			ExpandoTableConstants.DEFAULT_TABLE_NAME, 
																			EdisonExpando.USER_VC_TOKEN + String.valueOf(thisGroupId)
																			);
			setExpandoPermissions(user.getExpandoBridge().getCompanyId(), toKenColumn); 
		
			ExpandoColumn expiredColumn = ExpandoColumnLocalServiceUtil.getColumn(
																			user.getExpandoBridge().getCompanyId(), 
																			user.getExpandoBridge().getClassName(), 
																			ExpandoTableConstants.DEFAULT_TABLE_NAME, 
																			EdisonExpando.USER_VC_TOKEN_EXPIRED + String.valueOf(thisGroupId)
																			);
			setExpandoPermissions(user.getExpandoBridge().getCompanyId(), expiredColumn);
		}
		
		user.getExpandoBridge().setAttribute(EdisonExpando.USER_VC_TOKEN + String.valueOf(thisGroupId), icebreakerVcToken.getVcToken());
		user.getExpandoBridge().setAttribute(EdisonExpando.USER_VC_TOKEN_EXPIRED + String.valueOf(thisGroupId), icebreakerVcToken.getVcTokenExpired());
		return icebreakerVcToken;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void setExpandoPermissions(long companyId, ExpandoColumn column) throws SystemException {
        
		try {
	 
			Role userRole = RoleLocalServiceUtil.getRole(companyId, EdisonRoleConstants.USER);
			Role adminRole = RoleLocalServiceUtil.getRole(companyId, EdisonRoleConstants.ADMINISTRATOR);
	 
	          
			if (userRole != null && adminRole != null) {
				// define actions 
				String[] actionIds = new String[] { ActionKeys.VIEW, ActionKeys.UPDATE };
				
				Map<Long, String[]> map = new HashMap();
				map.put(userRole.getRoleId(), actionIds);
				map.put(adminRole.getRoleId(), actionIds);
	                
				// set the permission
				ResourcePermissionLocalServiceUtil.setResourcePermissions(
	                															companyId, 
	                															ExpandoColumn.class.getName(), 
	                															ResourceConstants.SCOPE_INDIVIDUAL, 
	                															String.valueOf(column.getColumnId()), 
	                															map
	                															);
	                	                
	            }
	      } catch (PortalException pe) {
	      }
	}
	
	public static IcebreakerVcToken getIceBreakerToken(User user, long groupId, Group thisGroup, ThemeDisplay themeDisplay) throws SystemException, NumberFormatException, MalformedURLException, PortalException, IOException, ParseException 
	{
		IcebreakerVcToken icebreakerVcToken = new IcebreakerVcToken();
		String userScreenName = "";
		String userPassword = "";

		if(EdisonUserUtil.isRegularRole(user, EdisonRoleConstants.ADMINISTRATOR) || EdisonUserUtil.isSiteRole(user, groupId, EdisonRoleConstants.SITE_ADMINISTRATOR))
		{
			userScreenName = (String)thisGroup.getExpandoBridge().getAttribute(EdisonExpando.SITE_ICEBREAKER_ADMIN_ID);
			userPassword = (String)thisGroup.getExpandoBridge().getAttribute(EdisonExpando.SITE_ICEBREAKER_ADMIN_PWD);
		}
		else
		{
			userScreenName = String.valueOf(user.getScreenName());
			userPassword = user.getPassword();
		}
		
//		if(thisGroup.getParentGroupId() == 0){ //포탈
//			String visitSite = themeDisplay.getUser().getExpandoBridge().getAttribute(EdisonExpando.USER_VISIT_SITE).toString();
//			List<Group> groupList = GroupLocalServiceUtil.getGroups(themeDisplay.getCompanyId(), thisGroup.getGroupId(), true);//하위 그룹 리스트
//			
//			for(Group group : groupList){
//				if(visitSite.equals(group.getName())){
//					groupId = group.getGroupId();
//					thisGroup = GroupLocalServiceUtil.getGroup(groupId);
//					break;
//				}
//			}
//		}
		
		if(VCRegisterUtil_fileTest.isVcInfo(groupId, userScreenName) == 200){  
			if(user.getExpandoBridge().hasAttribute(EdisonExpando.USER_VC_TOKEN + String.valueOf(groupId))){
				
				icebreakerVcToken.setVcToken(CustomUtil.strNull(user.getExpandoBridge().getAttribute(EdisonExpando.USER_VC_TOKEN + String.valueOf(groupId))));				
				icebreakerVcToken.setVcTokenExpired(CustomUtil.strNull(user.getExpandoBridge().getAttribute(EdisonExpando.USER_VC_TOKEN_EXPIRED + String.valueOf(groupId)), "0"));
	
				if(Integer.parseInt(icebreakerVcToken.getVcTokenExpired()) <= Integer.parseInt(CustomUtil.dateToStringFormat(new Date(), "yyyyMMdd"))){
					//시간이 지난 토큰인 경우 새로운 토큰 발행 및 커스텀 필드 저장				
					icebreakerVcToken = TokenProviderUtil_fileTest.getVcToken(groupId, userScreenName, userPassword);
		
					//Icebreaker에 회원정보는 있으나 로그인 되지 않는 경우 비밀번호 변경으로 인한것으로 판단하여 비밀번호 update후에 다시 로그인하여 토큰을 요청 합니다. 
					if(icebreakerVcToken.getResultCode() != 200){
						int updateResult = VCRegisterUtil_fileTest.VCUpdate(groupId, userScreenName, userPassword, user.getEmailAddress());
						if(updateResult==200){
							icebreakerVcToken = TokenProviderUtil_fileTest.getVcToken(groupId, userScreenName, userPassword);
						}
					}
					
					if(icebreakerVcToken.getResultCode() == 200){
						icebreakerVcToken.setVcToken(icebreakerVcToken.getVcToken());					
						icebreakerVcToken.setVcTokenExpired(icebreakerVcToken.getVcTokenExpired());
						
						user.getExpandoBridge().setAttribute(EdisonExpando.USER_VC_TOKEN + String.valueOf(groupId), icebreakerVcToken.getVcToken());
						user.getExpandoBridge().setAttribute(EdisonExpando.USER_VC_TOKEN_EXPIRED + String.valueOf(groupId), icebreakerVcToken.getVcTokenExpired());
					}else{
						log.debug("SimulationLocalServiceImpl : Icebreaker getOrCreateToken Error !!");
					}
				}
			}else{//icebreaker 계정은 있으나 포털에 expando가 없는 경우 expando 추가 생성
				icebreakerVcToken = IcebreakerUtil.createExpandoUserVctoken(user, groupId, userScreenName, userPassword);
			}
		}else{ // Icebreaker 계정이 없는경우
			//icebreaker 계정도 없는 경우 생성
			String universityField = (String)user.getExpandoBridge().getAttribute(EdisonExpando.USER_UNIVERSITY);
			String virtualLabId = (String)user.getExpandoBridge().getAttribute(EdisonExpando.USER_LAB_ID);
			String classId = (String)user.getExpandoBridge().getAttribute(EdisonExpando.USER_CLASS_ID);
			String majorField = (String)user.getExpandoBridge().getAttribute(EdisonExpando.USER_MAJOR);
			
			int resultRegist = VCRegisterUtil_fileTest.VCRegist(groupId, userScreenName, userPassword, user.getEmailAddress(), user.getFirstName(), universityField, virtualLabId, classId, majorField);
			
			if (resultRegist == 201) {
				//icebreaker 가입이 성공한 경우 신규 토큰 발행 및 커스텀 필드 추가
				icebreakerVcToken = IcebreakerUtil.createExpandoUserVctoken(user, groupId, userScreenName, userPassword);
			}
		}
		return icebreakerVcToken;
	}
	
	public static String getSimulationResult(String icebreakerUrl, String vcToken, String jobUuid,String dirPath) throws IOException{
		StringBuffer responseBuffer = new StringBuffer();
		
		if(!CustomUtil.strNull(vcToken).equals("")){
			URL url = new URL(icebreakerUrl+"/api/job/"+CustomUtil.strNull(jobUuid)+"/output?dir="+dirPath);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Content-Type", "application/xml");		
			conn.setRequestProperty("Authorization", "Basic "+CustomUtil.strNull(vcToken));
			
			if (conn.getResponseCode() == 200) {
				BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
				
				String  output = "";		
				while ((output = br.readLine()) != null) {			
					responseBuffer.append(output);
				}
				
			}else if (conn.getResponseCode() == 400) {
				System.out.println("Failed IcebreakerService [ getSimulationResult ] : BAD REQUEST : wrong body content - HTTP error code : " + conn.getResponseCode());		
			}else if (conn.getResponseCode() == 401) {
				System.out.println("Failed IcebreakerService [ getSimulationResult ] : UNAUTHORIZED : access denied - HTTP error code : " + conn.getResponseCode());		
			}else if (conn.getResponseCode() == 404) {
				System.out.println("Failed IcebreakerService [ getSimulationResult ] : NOT FOUND : no existing job - HTTP error code : " + conn.getResponseCode());
			}else{			
				System.out.println("Failed IcebreakerService [ getSimulationResult ] : ETC : etc error - HTTP error code : " + conn.getResponseCode());
			}
			
			conn.disconnect();
		}else{
			System.out.println("Failed IcebreakerService [ retrieveDir ] : Token is NOT NULL - Request error code : 999");
		}
		return responseBuffer.toString();
	}
	
	// JSONARRAY 정렬
	public static JSONArray sortJsonArray(JSONArray array, String fileListType, String fileListValue,String sortValue)
	{
		final String sortField = sortValue;
	    List<JSONObject> jsons = new ArrayList<JSONObject>();
	    Matcher m;
	    Pattern p = null;
	    if(fileListType.equals("EXT"))
	    {
	    	p = Pattern.compile("\\.("+fileListValue+")$", Pattern.CASE_INSENSITIVE);
	    }
	    
	    for (int i = 0; i < array.size(); i++) {
	    	if(fileListType.equals("FILE") && fileListValue.equals(array.getJSONObject(i).getString("name")))
	    	{
	    		jsons.add(array.getJSONObject(i));
	    	}
	    	else if(fileListType.equals("EXT") && p != null)
	    	{
	    		m = p.matcher( array.getJSONObject(i).getString("name") );
				if(m.find())
					jsons.add(array.getJSONObject(i));
	    	}
	    	else if( !fileListType.equals("FILE") && !fileListType.equals("EXT"))
	    	{
	    		jsons.add(array.getJSONObject(i));
	    	}
	    	else if( fileListType.equals("TEMP") && fileListValue.equals(array.getJSONObject(i).getString("name")))
	    	{
	    		jsons.add(array.getJSONObject(i));
	    	}
	    }
	    
	    Collections.sort(jsons, new Comparator<JSONObject>() {
	        @Override
	        public int compare(JSONObject lhs, JSONObject rhs) {
	            String lid = lhs.getString(sortField);
	            String rid = rhs.getString(sortField);
	            return lid.compareTo(rid);
	        }
	    });
	    return JSONArray.fromObject(JSONSerializer.toJSON(jsons.toString()));
	}
}
