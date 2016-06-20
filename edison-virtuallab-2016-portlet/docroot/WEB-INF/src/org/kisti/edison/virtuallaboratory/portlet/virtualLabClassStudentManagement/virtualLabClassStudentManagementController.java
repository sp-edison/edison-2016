package org.kisti.edison.virtuallaboratory.portlet.virtualLabClassStudentManagement;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.kisti.edison.customauthmanager.service.UserGroupRoleCustomLocalServiceUtil;
import org.kisti.edison.model.EdisonExpando;
import org.kisti.edison.model.EdisonMessageConstants;
import org.kisti.edison.model.EdisonRoleConstants;
import org.kisti.edison.util.CustomUtil;
import org.kisti.edison.util.EdisonFileUtil;
import org.kisti.edison.util.EdisonTempUserUtil;
import org.kisti.edison.util.EdisonUserUtil;
import org.kisti.edison.util.RequestUtil;
import org.kisti.edison.virtuallaboratory.model.VirtualLabUser;
import org.kisti.edison.virtuallaboratory.service.SurveyLocalServiceUtil;
import org.kisti.edison.virtuallaboratory.service.VirtualLabClassLocalServiceUtil;
import org.kisti.edison.virtuallaboratory.service.VirtualLabUserLocalServiceUtil;
import org.kisti.edison.virtuallaboratory.service.VirtualLabUserTempLocalServiceUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.UserPasswordException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.security.permission.PermissionThreadLocal;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.UserServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFileEntryTypeConstants;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

@Controller
@RequestMapping("VIEW")
public class virtualLabClassStudentManagementController {
	private static Log log = LogFactoryUtil.getLog(virtualLabClassStudentManagementController.class);
	
	@RequestMapping
	// default
	public String view(RenderRequest request, RenderResponse response, ModelMap model) {
		try {
			HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(request);
			httpRequest = PortalUtil.getOriginalServletRequest(httpRequest);
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			User user = PortalUtil.getUser(request);
			long groupId = PortalUtil.getScopeGroupId(request);
			long companyId = PortalUtil.getCompanyId(request);
	
			Role virtualLabOwner = RoleLocalServiceUtil.fetchRole(companyId, EdisonRoleConstants.VIRTUAL_LAB_OWNER);
			Role virtualLabClassOwner = RoleLocalServiceUtil.fetchRole(companyId, EdisonRoleConstants.VIRTUAL_CLASS_OWNER);
			Role virtualLabClassManager = RoleLocalServiceUtil.fetchRole(companyId, EdisonRoleConstants.VIRTUAL_CLASS_MANAGER);
	
			String classId = httpRequest.getParameter("classId");
	
			Map<String, Object> params = RequestUtil.getParameterMap(httpRequest);
	
			if(EdisonUserUtil.isRegularRole(user, EdisonRoleConstants.TEMP_USER)) {
				classId = (String) user.getExpandoBridge().getAttribute(EdisonExpando.USER_CLASS_ID);
			} else {
				for (Map.Entry<String,Object> str : params.entrySet()) {
					if(str.getKey().contains("classId")) {
						classId =  (String) str.getValue();
					}
				}
			}
	
			long classId_ = GetterUtil.get(classId, 0L);
			Map <String, String> virtualLabClassInfo = null;
	
			if(classId_ > 0) {
				virtualLabClassInfo = VirtualLabClassLocalServiceUtil.getVirtualClassMainVisual(classId_,	themeDisplay.getLocale());
			} else {
				return "virtualLabClassStudentManagement/virtualClassStudentListNonePage";
			}
	
			model.addAttribute("classId", classId_);
			model.addAttribute("virtualLabClassInfo", virtualLabClassInfo);
			
			if (EdisonUserUtil.isRegularRole(user, RoleConstants.ADMINISTRATOR)	// PORTAL ADMINISTRATOR 체크
					|| EdisonUserUtil.isSiteRole(user, groupId, RoleConstants.SITE_ADMINISTRATOR)	// SITE ADMINSTRATOR	체크
					|| EdisonUserUtil.isSiteRole(user, groupId, RoleConstants.SITE_OWNER)	// SITE OWNER 체크
					|| UserGroupRoleCustomLocalServiceUtil.isRoleCustom(user.getUserId(), groupId, virtualLabOwner.getRoleId(), Long.parseLong(virtualLabClassInfo.get("virtualLabId")))
					|| UserGroupRoleCustomLocalServiceUtil.isRoleCustom(user.getUserId(), groupId, virtualLabClassOwner.getRoleId(), Long.parseLong(classId))
					|| UserGroupRoleCustomLocalServiceUtil.isRoleCustom(user.getUserId(), groupId, virtualLabClassManager.getRoleId(), Long.parseLong(classId))) // VIRTUAL LAB OWNER CHECK
			{
				// 설문조사 maxQuestionSeqNo 가져오기
				long maxQuestionSeqNo = SurveyLocalServiceUtil.getMaxQuestionSeq(GetterUtil.get(virtualLabClassInfo.get("virtualLabId"),0L));
				model.addAttribute("maxQuestionSeqNo", maxQuestionSeqNo);
				
				//학생등록양식파일 
				DLFolder folder = DLFolderLocalServiceUtil.fetchFolder(groupId, DLFileEntryTypeConstants.FILE_ENTRY_TYPE_ID_BASIC_DOCUMENT, "VIRTUALCLASS_STD_SAMPLE");
				if(folder != null) {
					List<DLFileEntry> dfeList = DLFileEntryLocalServiceUtil.getFileEntries(groupId, folder.getFolderId());
					if(dfeList != null && dfeList.size() > 0){
						DLFileEntry dfe = dfeList.get(0);
						Map fileMap = new HashMap();
						fileMap.put("fileEntryId", String.valueOf(dfe.getFileEntryId()));
						fileMap.put("fileRepositoryId", String.valueOf(dfe.getRepositoryId()));
						fileMap.put("fileUuid", String.valueOf(dfe.getUuid()));
						fileMap.put("fileTitle", dfe.getTitle());
						fileMap.put("fileUserId", String.valueOf(dfe.getUserId()));
						fileMap.put("fileExtension", String.valueOf(dfe.getExtension()));
						
						model.addAttribute("fileMap",fileMap);
					}
				}
				
				return "virtualLabClassStudentManagement/virtualClassStudentList";
			} else {
				model.addAttribute("userId", PortalUtil.getUserId(request));
				return "virtualLabClassStudentManagement/virtualClassStudentListNonePage";
			}
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			
			//Session Error Message
			SessionErrors.add(request, EdisonMessageConstants.SEARCH_ERROR);
			return "";
		}
	}

	@ResourceMapping(value = "virtualClassStudentList")
	public void getVirtualClassStudentList(ResourceRequest request, ResourceResponse response) throws SystemException, IOException, PortalException {
		String classId = ParamUtil.get(request, "classId", "0");
		String virtualLabId = ParamUtil.get(request, "virtualLabId", "0");
		String questionSeqNo = ParamUtil.get(request, "questionSeqNo", "0");
		String search_parameter = ParamUtil.get(request, "search_parameter", "");
		JSONObject obj = new JSONObject();
		if (classId != null && !classId.equals(0)) {
			List<Map<String, Object>> virtualClassStudentList = VirtualLabUserLocalServiceUtil.getVirtualClassStudentList(Long.parseLong(virtualLabId), Long.parseLong(classId), Long.parseLong(questionSeqNo), search_parameter, PortalUtil.getScopeGroupId(request));
			obj.put("virtualClassStudentList", virtualClassStudentList);
		}
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(obj.toString());
	}

	@ResourceMapping(value = "updateClassRegister")
	public void updateClassRegister(ResourceRequest request, ResourceResponse response) throws SystemException, IOException,	PortalException {
		String userId = ParamUtil.get(request, "userId", "0");
		String virtualLabUserId = ParamUtil.get(request, "virtualLabUserId", "0");
		String requestSort = ParamUtil.get(request, "requestSort", "");
		long groupId = PortalUtil.getScopeGroupId(request);
		JSONObject obj = new JSONObject();

		if (virtualLabUserId != null && !virtualLabUserId.equals(0)) {
			User user = UserLocalServiceUtil.fetchUser(Long.parseLong(userId));
			if (user != null) {
				if (requestSort.equals("CONFIRM")) {
					EdisonUserUtil.addGroup(user, EdisonRoleConstants.STUDENT_GROUP);
					EdisonUserUtil.addSiteRole(user, groupId,
							EdisonRoleConstants.VIRTUAL_CLASS_MEMBER);
				} else if (requestSort.equals("REQUEST")) {

				}
				VirtualLabUserLocalServiceUtil.updateVirtualLabUser(Long.parseLong(virtualLabUserId), requestSort);
			}
		}

		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(obj.toString());
	}

	@ResourceMapping(value = "addVirtualClassStudent")
	public void addVirtualClassStudent(ResourceRequest request,	ResourceResponse response) throws Exception {
		String virtualLabUserId = ParamUtil.get(request, "virtualLabUserId", "0");
		String requestSort = ParamUtil.get(request, "requestSort", "TEMP");
		long groupId = PortalUtil.getScopeGroupId(request);
		String classId = ParamUtil.get(request, "classId", "0");

		JSONObject obj = new JSONObject();

		String resultCode = "200";

		Map<String, String> params = RequestUtil.getParameterMap(request);

		params.put("groupId", String.valueOf(groupId));
		params.put("classId", classId);

		User user = null;
		try {
			user = EdisonTempUserUtil.addUser(request, params);
			int status = WorkflowConstants.STATUS_APPROVED;
			UserServiceUtil.updateStatus(user.getUserId(), status);

			EdisonUserUtil.addRegularRole(user, EdisonRoleConstants.TEMP_USER);
			EdisonUserUtil.addSiteRole(user, groupId, EdisonRoleConstants.VIRTUAL_CLASS_MEMBER);

			VirtualLabUserLocalServiceUtil.addTempUser(Long
					.parseLong(classId), user.getUserId(),
					(String) params.get("userStudentNumber"));
		} catch (Exception e) {
			if (user != null) {
				EdisonTempUserUtil.deleteUserException(user);
			}
			throw e;
		} finally {

		}

		VirtualLabUserLocalServiceUtil.updateVirtualLabUser(
				Long.parseLong(virtualLabUserId), requestSort); // 가상클래스 유저 정보
		// 테이블에 추가

		obj.put("resultCode", resultCode);

		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(obj.toString());
	}

	/*
	 * 학생삭제
	 */
	@ResourceMapping(value = "deleteVirtualClassUser")
	public void deleteVirtualClassUser(ResourceRequest request, ResourceResponse response) throws Exception {
		String result = "0";
		String virtualLabUserId = ParamUtil.get(request, "virtualLabUserId", "");
		long classId = ParamUtil.get(request, "classId", 0L);
		long groupId = PortalUtil.getScopeGroupId(request);
		String userScreenName = ParamUtil.get(request, "userScreenName", "");
		long companyId = PortalUtil.getCompanyId(request);
		JSONObject obj = new JSONObject();

		User user = UserLocalServiceUtil.fetchUserByScreenName(companyId, userScreenName);

		if (user != null) {
			EdisonTempUserUtil.deleteUser(user);	// 임시 유저 disabled
			VirtualLabUserLocalServiceUtil.deleteVirtualLabUser(Long.parseLong(virtualLabUserId));	// 임시유저 수강신청 정보 삭제
//			시뮬레이션 서비스 필요
//			SimulationJobLocalServiceUtil.deleteMonitoringByJobClassId(groupId, classId, user);	// 임시 유저 모니터링 정보 삭제
			result = "200";
		} else {
			VirtualLabUserLocalServiceUtil.deleteVirtualLabUser(Long.parseLong(virtualLabUserId)); 	// 임시유저 수강신청 정보 삭제
//			시뮬레이션 서비스 필요
//			SimulationJobLocalServiceUtil.deleteMonitoringByJobClassId(groupId, classId, user);	// 임시 유저 모니터링 정보 삭제
			result = "200";
		}

		obj.put("result", result);
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(obj.toString());
	}

	@ResourceMapping(value = "updateVirtualClassUser")
	public void updateVirtualClassUser(ResourceRequest request, ResourceResponse response) throws SystemException, IOException, PortalException {
		long virtualLabUserId = ParamUtil.get(request, "virtualLabUserId", 0);
		String userFirstName = ParamUtil.get(request, "userFirstName", "");
		String result = "200";

		VirtualLabUser virtualLabUser = VirtualLabUserLocalServiceUtil.getVirtualLabUser(virtualLabUserId);
		if (virtualLabUser != null) {
			User tempUser = UserLocalServiceUtil.getUser(virtualLabUser.getUserId());
			if (tempUser != null) {
				if(!userFirstName.equals("")) {
					tempUser.setFirstName(userFirstName);
					UserLocalServiceUtil.updateUser(tempUser);
				}
			} else {
				result = "400";
			}
		} else {
			result = "400";
		}

		JSONObject obj = new JSONObject();
		obj.put("result", result);
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(obj.toString());
	}

	/*
	 * 학생 비밀번호 초기화
	 */
	@ResourceMapping(value = "studentPasswordInit")
	public void studentPasswordInit(ResourceRequest request, ResourceResponse response) throws Exception {
		long virtualLabUserId = ParamUtil.get(request, "virtualLabUserId", 0);
		String result = "200";

		VirtualLabUser virtualLabUser = VirtualLabUserLocalServiceUtil.getVirtualLabUser(virtualLabUserId);
		if (virtualLabUser != null) {
			User tempUser = UserLocalServiceUtil.getUser(virtualLabUser.getUserId());
			PermissionChecker checker = PermissionCheckerFactoryUtil.create(tempUser);
			PermissionThreadLocal.setPermissionChecker(checker);
			if (tempUser != null) {
				UserLocalServiceUtil.updatePasswordManually(tempUser.getUserId(), tempUser.getScreenName(), false, false, new Date());
			} else {
				result = "400";
			}
		} else {
			result = "400";
		}

		JSONObject obj = new JSONObject();
		obj.put("result", result);
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(obj.toString());
	}

	/**
	 * 학생 엑세파일 일괄등록 validation체크후 결과값 리턴
	 **/
	@ResourceMapping(value = "studentCreateBatch")
	public void studentCreateBatch(ResourceRequest request, ResourceResponse response) throws Exception {
		String resultCode = "200";
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		Map params = RequestUtil.getParameterMap(request);

		long groupId = themeDisplay.getScopeGroupId();
		String virtualLabId = CustomUtil.strNull(params.get("virtualLabId"));
		String classId = CustomUtil.strNull(params.get("classId"));
		String virtualClassCd = CustomUtil.strNull(params.get("virtualClassCd"));
		//		String virtualLabUniversityFieldNm = CustomUtil.strNull(params.get("virtualLabUniversityFieldNm"));
		//		String classTitle = CustomUtil.strNull(params.get("classTitle"));

		HttpServletRequest req = PortalUtil.getHttpServletRequest(request);
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();

		params.put("groupId", String.valueOf(groupId));

		List resultList = new ArrayList();

		if (!ServletFileUpload.isMultipartContent(req)) {
			throw new IllegalArgumentException("Request is not multipart, please 'multipart/form-data' enctype for your form.");
		}

		//폴더가 없으면 폴더 생성
		String STUDENT_LIST_TEMP = PropsUtil.get(PropsKeys.LIFERAY_HOME)+"/STUDENT_LIST_TEMP";
		File folder = new File(STUDENT_LIST_TEMP);		 
		if(!folder.isDirectory()) folder.mkdirs();

		ServletFileUpload uploadHandler = new ServletFileUpload(new DiskFileItemFactory(200000, new File(STUDENT_LIST_TEMP)));

		if (!virtualLabId.equals("") && !classId.equals("")) {

			File file = null;
			try {
				List<FileItem> items = uploadHandler.parseRequest(req);
				for (FileItem item : items) {
					if (!item.isFormField()) {
						String fileName = item.getName();
						if(fileName.contains("\\")) {
							fileName = fileName.substring(fileName.lastIndexOf("\\") + 1, fileName.length());
						}
						file = FileUtil.createTempFile(fileName);

						item.write(file);
						try {
							// 확장자 구하기
							int lastDotIndex = item.getName().lastIndexOf(".");
							String ext = item.getName().substring(lastDotIndex)	.toLowerCase(); // 확장자 구하기

							// 워크북 생성
							Workbook workbook = null;

							// Workbook
							if (ext.equals(".xls")) {// 2003이전 통합버젼
								workbook = new HSSFWorkbook(
										item.getInputStream());
							} else if (ext.equals(".xlsx")) {// 2007이후
								workbook = new XSSFWorkbook(
										item.getInputStream());
							} else {
								throw new IOException("File Type Exception !!");
							}
							List <String> tempUserStudentNumberList = new ArrayList<String> ();
							
							List list = EdisonTempUserUtil.getListByUserExcel(workbook);
							if (list.size() != 0) {
								for (int i = 0; i < list.size(); i++) {
									boolean validationUser = false;
									boolean duplicateUser = false;
									String errorMessage = "";
									
									Map dataMap = (Map) list.get(i);
									Map<String, Object> inserMap = new HashMap<String, Object>();

									String seqNo = CustomUtil.strNull(dataMap.get("seqNo"));
									String userStudentNumber = CustomUtil.strNull(dataMap.get("userStudentNumber"));
									String userName = CustomUtil.strNull(dataMap.get("userName"));
									
									
									if(tempUserStudentNumberList.contains(userStudentNumber)) {
										errorMessage = "Duplicate Value";
										duplicateUser = true;
									} else {
										tempUserStudentNumberList.add(userStudentNumber);
									}
									
									if(!duplicateUser) {
										if (userName.equals("")	|| userStudentNumber.equals("")) {
											errorMessage = "Invalid Infomation";
										} else {
	
											if (userStudentNumber.length() < 4 || userStudentNumber.length() > 27) {
												errorMessage = "ID length : " + (userStudentNumber.length() + 5);
											} else {
												try {
													User user = UserLocalServiceUtil.getUserByScreenName(themeDisplay.getCompanyId(),virtualClassCd + userStudentNumber);
													errorMessage = "Duplicate ID";
												} catch (NoSuchUserException e) {
													validationUser = true;
												}
											}
										}
									}

									inserMap.put("userScreenName", virtualClassCd + userStudentNumber);
									inserMap.put("userName", userName);
									inserMap.put("userStudentNumber", userStudentNumber);
									inserMap.put("virtualLabId", virtualLabId);
									inserMap.put("classId", classId);
									inserMap.put("status", "TRUE");
									inserMap.put("seqNo", seqNo);

									if (validationUser) {
										long newSeqNo = (Long) VirtualLabUserTempLocalServiceUtil.addVirtualLabUserTemp(inserMap).getSeqNo();
										// int newSeqNo = (Integer)
										// cyberLabUserTempService.insert(inserMap);
										inserMap.put("seqNo", seqNo);
										inserMap.put("newSeqNo", newSeqNo);
										inserMap.put("errCode", "N");
									} else {
										inserMap.put("errCode", "Y");
										inserMap.put("errMsg", errorMessage);
									}

									resultList.add(inserMap);
								}
							}
						} catch (Exception e) {
							// TODO: handle exception
						}
						item.delete();
					}
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			} finally {
				FileUtil.delete(file);
			}

			JSONArray json = new JSONArray();
			json = JSONArray.fromObject(JSONSerializer.toJSON(resultList));

			StringBuffer responseBuffer = new StringBuffer();
			responseBuffer.append("{");
			responseBuffer.append("'dataList':");
			responseBuffer.append(CustomUtil.strNull(json.toString()));
			responseBuffer.append("}");
			//			response.setContentType("application/json; charset=UTF-8");
			// log.info(responseBuffer.toString());
			writer.write(responseBuffer.toString());
		} else {
			writer.write(resultCode);
		}

	}

	/**
	 * 학생 엑세파일 일괄등록 validation 확인후 선택된 학생생성
	 **/
	@ResourceMapping(value = "studentExcelInsert")
	public void studentExcelInsert(ResourceRequest request, ResourceResponse response) throws Exception {

		// CustomCyberLabUserTemp에 저장되어 있는 사용자정보를 불어와서 계정을 생성한다.
		String resultCode = "200";
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		Map<String, Object> params = RequestUtil.getParameterMap(request);

		String virtualLabId = CustomUtil.strNull(params.get("virtualLabId"));
		String classId = CustomUtil.strNull(params.get("classId"));
		String universityField = CustomUtil.strNull(params.get("universityField"));
		String virtualClassCd = CustomUtil.strNull(params.get("virtualClassCd"));
		
		long groupId = themeDisplay.getScopeGroupId();

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();

		String[] seqNo_arr = null;
		String seqNo = "";
		User user = null;
		try {

			if (params.get("seqNo") instanceof String[]) {
				seqNo_arr = (String[]) params.get("seqNo");
			} else {
				seqNo = (String) params.get("seqNo");
			}

			if (seqNo_arr != null) {

				for (int i = 0; i < seqNo_arr.length; i++) {
					String tempSeqNo = seqNo_arr[i];
					Map<String, Object> insertMap = VirtualLabUserTempLocalServiceUtil
							.getVirtualLabUserTemp(Long.parseLong(tempSeqNo),
									Long.parseLong(virtualLabId),
									Long.parseLong(classId));

					insertMap.put("universityField", universityField);
					insertMap.put("groupId", String.valueOf(groupId));
					insertMap.put("userScreenName", virtualClassCd + insertMap.get("userStudentNumber"));

					user = EdisonTempUserUtil.addUser(request, insertMap);

					EdisonUserUtil.addRegularRole(user, EdisonRoleConstants.TEMP_USER);
					EdisonUserUtil.addSiteRole(user, groupId, EdisonRoleConstants.VIRTUAL_CLASS_MEMBER);

					VirtualLabUserLocalServiceUtil.addTempUser(Long
							.parseLong(classId), user.getUserId(),
							CustomUtil.strNull(insertMap
									.get("userStudentNumber")));
				}

			} else if (!seqNo.equals("")) {
				Map<String, Object> insertMap = VirtualLabUserTempLocalServiceUtil
						.getVirtualLabUserTemp(Long.parseLong(seqNo),
								Long.parseLong(virtualLabId),
								Long.parseLong(classId));

				insertMap.put("universityField", universityField);
				insertMap.put("groupId", groupId);

				user = EdisonTempUserUtil.addUser(request, insertMap);
				int status = WorkflowConstants.STATUS_APPROVED;
				UserServiceUtil.updateStatus(user.getUserId(), status);

				EdisonUserUtil.addRegularRole(user, EdisonRoleConstants.TEMP_USER);
				EdisonUserUtil.addSiteRole(user, groupId, EdisonRoleConstants.VIRTUAL_CLASS_MEMBER);

				VirtualLabUserLocalServiceUtil.addTempUser(
						Long.parseLong(classId), user.getUserId(),
						CustomUtil.strNull(insertMap.get("userStudentNumber")));
			}

		} catch (Exception e) {
			if (user != null) {
				EdisonTempUserUtil.deleteUserException(user);
			}
			e.printStackTrace();
			throw e;
		} finally {

		}
		writer.write(resultCode);
	}

	@ResourceMapping(value = "registerDenied")
	public void registerDenied(ResourceRequest request, ResourceResponse response) throws Exception {
		Map params = RequestUtil.getParameterMap(request);
		String result = "0";

		VirtualLabUser virtualLabUser = VirtualLabUserLocalServiceUtil.updateVirtualLabUserProcessNote(params);
		if(virtualLabUser != null) {
			result = "200";
		}

		JSONObject obj = new JSONObject();
		obj.put("result", result);
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(obj.toString());
	}

	@ResourceMapping(value = "getTempUserInfomation")
	public void getTempUserInfomation(ResourceRequest request, ResourceResponse response) throws Exception {
		Map params = RequestUtil.getParameterMap(request);
		long virtualLabUserId = GetterUtil.get(params.get("virtualLabUserId"), 0L);
		Map<String, Object> tempUserInfomation = null;

		if(virtualLabUserId > 0) {
			VirtualLabUser virtualLabUser = VirtualLabUserLocalServiceUtil.getVirtualLabUser(virtualLabUserId);
			User tempUser = UserLocalServiceUtil.getUser(virtualLabUser.getUserId());
			tempUserInfomation = new HashMap<String, Object>();
			tempUserInfomation.put("virtualLabUserId", virtualLabUser.getVirtualLabUserId());
			tempUserInfomation.put("userStudentNumber", virtualLabUser.getUserStudentNumber());
			tempUserInfomation.put("userScreenName", tempUser.getScreenName());
			tempUserInfomation.put("userFirstName", tempUser.getFirstName());
		}

		JSONObject obj = new JSONObject();
		obj.put("tempUserInfomation", tempUserInfomation);
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(obj.toString());
	}

/*	마이그레이션 엑셀 유저 생성 코드
 * 
 * 	@ResourceMapping(value = "userCreateBatch")
	public void userCreateBatch(ResourceRequest request, ResourceResponse response) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		Map params = RequestUtil.getParameterMap(request);
		String resultCode = "200";
		long groupId = themeDisplay.getScopeGroupId();
		
		HttpServletRequest req = PortalUtil.getHttpServletRequest(request);
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();

		if (!ServletFileUpload.isMultipartContent(req)) {
			throw new IllegalArgumentException("Request is not multipart, please 'multipart/form-data' enctype for your form.");
		}
		String STUDENT_LIST_TEMP = PropsUtil.get(PropsKeys.LIFERAY_HOME)+"/STUDENT_LIST_TEMP";
		File folder = new File(STUDENT_LIST_TEMP);		 
		if(!folder.isDirectory()) folder.mkdirs();

		ServletFileUpload uploadHandler = new ServletFileUpload(new DiskFileItemFactory(200000, new File(STUDENT_LIST_TEMP)));
		File file = null;
		try {
			List<FileItem> items = uploadHandler.parseRequest(req);
			for (FileItem item : items) {
				if (!item.isFormField()) {
					String fileName = item.getName();
					if(fileName.contains("\\")) {
						fileName = fileName.substring(fileName.lastIndexOf("\\") + 1, fileName.length());
					}
					file = FileUtil.createTempFile(fileName);

					item.write(file);
					try {
						// 확장자 구하기
						int lastDotIndex = item.getName().lastIndexOf(".");
						String ext = item.getName().substring(lastDotIndex)	.toLowerCase(); // 확장자 구하기

						// 워크북 생성
						Workbook workbook = null;

						// Workbook
						if (ext.equals(".xls")) {// 2003이전 통합버젼
							workbook = new HSSFWorkbook(
									item.getInputStream());
						} else if (ext.equals(".xlsx")) {// 2007이후
							workbook = new XSSFWorkbook(
									item.getInputStream());
						} else {
							throw new IOException("File Type Exception !!");
						}
						List<Map<String, String>> list = userExcelUtil.getListByUserExcel(workbook);
						if (list.size() != 0) {
							for (int i = 0; i < list.size(); i++) {
								Map<String, String> userMap =list.get(i);
								userExcelUtil.addUser(request, userMap);
							}
						}
					} catch (UserPasswordException pe) {
						pe.printStackTrace();
						throw pe;
					} catch (Exception e) {
						resultCode = "100";
						e.printStackTrace();
						throw e;
					} finally {
						
					}
				}
			}
		} catch (Exception e) {
			resultCode = "300";
			e.printStackTrace();
			throw e;
		} finally {
			writer.print(resultCode);
		}
	}*/
	
	@ResourceMapping(value="edisonFileDownload")
	public void edisonFileDownload(ResourceRequest request, ResourceResponse response) throws IOException, SQLException, PortalException, SystemException{

		Map paramsMap = RequestUtil.getParameterMap(request);
		long fileEntryId = Long.parseLong(CustomUtil.strNull(paramsMap.get("fileEntryId")));
		
		EdisonFileUtil.edisonFileDownload(response, fileEntryId);
	}
}


