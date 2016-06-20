package org.kisti.edison.content.portlet.siteMainContent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.RenderRequest;

import org.kisti.edison.content.service.AdvancedContentLocalServiceUtil;
import org.kisti.edison.model.EdisonExpando;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("VIEW")
public class SiteMainContentController {
	
	private static Log log = LogFactoryUtil.getLog(SiteMainContentController.class);
	
	@RequestMapping//default
	public String view(RenderRequest request, ModelMap model){
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getScopeGroupId();
		try {
			//고급 컨텐츠 조회
			List<Map<String, Object>> advancedList = retrieveListAdvanced(themeDisplay, groupId);
			
			//클러스터 조회
			List<Map<String, Object>> clusterList = new ArrayList<Map<String, Object>>();
			
			String icebreakerUrl = (String) GroupLocalServiceUtil.getGroup(groupId).getExpandoBridge().getAttribute(EdisonExpando.SITE_ICEBREAKER_URL);
			JSONObject jsonObj = retrieveCluster(icebreakerUrl);
			JSONArray jsonArray = jsonObj.getJSONObject("clusterList").getJSONArray("clusters");
			
			JSONObject returnObj = null;
			HashMap dataMap = null;
			for(int i=0; i<jsonArray.size();i++){
				dataMap = new HashMap<String, String>();
				returnObj = (JSONObject) jsonArray.get(i);
				dataMap.put("clusterName", returnObj.get("name"));
				dataMap.put("total", returnObj.getJSONObject("runtime").get("totalCores"));
				dataMap.put("used", returnObj.getJSONObject("runtime").get("busyCores"));
				dataMap.put("avail", returnObj.getJSONObject("runtime").get("freeCores"));
				clusterList.add(dataMap);
			}
			
			model.addAttribute("advancedList", advancedList);
			model.addAttribute("clusterList", clusterList);
			
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return "/contentList";
	}
	
	
	
	/**
	 * 고급컨텐츠 조회
	 * @param themeDisplay
	 * @param groupId
	 * @return
	 * @throws Exception 
	 */
	private List<Map<String, Object>> retrieveListAdvanced(ThemeDisplay themeDisplay, long groupId) throws Exception{
		return AdvancedContentLocalServiceUtil.getAdvancedContentListByGroupId(groupId,null,themeDisplay.getLocale(),themeDisplay);
		
	}
	
	
	/**
	 * icebreaker 클러스터 리스트 조회
	 * @param icebreakerUrl
	 * @return
	 * @throws PortalException
	 * @throws IOException
	 */
	private JSONObject retrieveCluster(String icebreakerUrl) throws PortalException, IOException{
		StringBuffer responseBuffer = new StringBuffer();
		JSONObject json = new JSONObject();
		
		URL url = new URL(icebreakerUrl+"/test/api/cluster/list");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		
		conn.setDoOutput(true);
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");
		conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");
		
		
		if (conn.getResponseCode() == 400) {
			throw new PortalException("Failed IcebreakerService [ retrieveCluster ] : BAD REQUEST: bad parameters");
		}else{
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			String  output = "";		
			while ((output = br.readLine()) != null) {			
				responseBuffer.append(output);
			}
			json.put("clusterList", responseBuffer.toString());
		}
		conn.disconnect();
		return json;
	}
	
	
}
