/********************************************************************************* 
* Ephesoft is a Intelligent Document Capture and Mailroom Automation program 
* developed by Ephesoft, Inc. Copyright (C) 2010-2012 Ephesoft Inc. 
* 
* This program is free software; you can redistribute it and/or modify it under 
* the terms of the GNU Affero General Public License version 3 as published by the 
* Free Software Foundation with the addition of the following permission added 
* to Section 15 as permitted in Section 7(a): FOR ANY PART OF THE COVERED WORK 
* IN WHICH THE COPYRIGHT IS OWNED BY EPHESOFT, EPHESOFT DISCLAIMS THE WARRANTY 
* OF NON INFRINGEMENT OF THIRD PARTY RIGHTS. 
* 
* This program is distributed in the hope that it will be useful, but WITHOUT 
* ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS 
* FOR A PARTICULAR PURPOSE.  See the GNU Affero General Public License for more 
* details. 
* 
* You should have received a copy of the GNU Affero General Public License along with 
* this program; if not, see http://www.gnu.org/licenses or write to the Free 
* Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 
* 02110-1301 USA. 
* 
* You can contact Ephesoft, Inc. headquarters at 111 Academy Way, 
* Irvine, CA 92617, USA. or at email address info@ephesoft.com. 
* 
* The interactive user interfaces in modified source and object code versions 
* of this program must display Appropriate Legal Notices, as required under 
* Section 5 of the GNU Affero General Public License version 3. 
* 
* In accordance with Section 7(b) of the GNU Affero General Public License version 3, 
* these Appropriate Legal Notices must retain the display of the "Ephesoft" logo. 
* If the display of the logo is not reasonably feasible for 
* technical reasons, the Appropriate Legal Notices must display the words 
* "Powered by Ephesoft". 
********************************************************************************/ 

package com.ephesoft.dcma.gwt.reporting.client;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ephesoft.dcma.core.common.Order;
import com.ephesoft.dcma.core.common.WorkflowType;
import com.ephesoft.dcma.gwt.core.client.DCMARemoteServiceAsync;
import com.ephesoft.dcma.gwt.core.shared.ReportDTO;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * This class enables the user to generate execution reports on various basis asynchronously.
 * 
 * @author Ephesoft
 */
public interface ReportingModelServiceAsync extends DCMARemoteServiceAsync {

	/**
	 * API to get System Statistics between the given startDate and endDate asynchronously.
	 * 
	 * @param startDate {@link Date}
	 * @param endDate {@link Date}
	 * @return List<{@link Integer}>
	 * @param callback {@link AsyncCallback} < List < {@link Integer} > >
	 */
	void getSystemStatistics(Date startDate, Date endDate, List<String> batchClassIdList,AsyncCallback<List<Integer>> callback);

	/**
	 * API to get flag whether another user is already connected with the report DB.
	 * 
	 * @param callback {@link AsyncCallback} < Boolean >
	 */
	void isAnotherUserConnected(AsyncCallback<Boolean> callback);

	/**
	 * API to get Table Data for a workflow type between the given startDate and endDate for a list of batch Class Ids in the specified
	 * order asynchronously.
	 * 
	 * @param batchClassIds List<{@link String}>
	 * @param workflowType {@link WorkflowType}
	 * @param startDate {@link Date}
	 * @param endDate {@link Date}
	 * @param startIndex int
	 * @param maxResults int
	 * @param order {@link Order}
	 * @param callback {@link AsyncCallback} < List < {@link ReportDTO} > >
	 */
	void getTableData(List<String> batchClassIds, WorkflowType workflowType, Date startDate, Date endDate, int startIndex,
			int maxResults, Order order, AsyncCallback<List<ReportDTO>> callback);

	/**
	 * API to get Table Data For User between the given startDate and endDate for a list of batch Class Ids in the specified order
	 * asynchronously.
	 * 
	 * @param batchClassIds List<{@link String}>
	 * @param user {@link String}
	 * @param startDate {@link Date}
	 * @param endDate {@link Date}
	 * @param startIndex int
	 * @param maxResults int
	 * @param order {@link Order}
	 * @param callback {@link AsyncCallback} < List < {@link ReportDTO} > >
	 */
	void getTableDataForUser(List<String> batchClassIds, String user, Date startDate, Date endDate, int startIndex, int maxResults,
			Order order, AsyncCallback<List<ReportDTO>> callback);

	/**
	 * API to get All Users available asynchronously.
	 * 
	 * @param callback {@link AsyncCallback} < List < {@link String} > >
	 */
	void getAllUsers(AsyncCallback<List<String>> callback);

	/**
	 * API to get custom report button pop up url ,title,xDimension and yDimension asynchronously.
	 * 
	 * @param callback {@link AsyncCallback} < Map<{@link String}, {@link String}> >
	 */
	void getCustomReportButtonPopUpConfigs(AsyncCallback<Map<String, String>> callback);

	/**
	 * API to get All Batch Classes available in the form of map of identifier and it's description asynchronously.
	 * 
	 * @param callback {@link AsyncCallback} < List < Map<{@link String}, {@link String}> > >
	 */
	void getAllBatchClasses(AsyncCallback<Map<String, String>> callback);

	/**
	 * API to get Total Row Count for workflow type between the given startDate and endDate and list of batch class id's
	 * asynchronously.
	 * 
	 * @param batchClassIds List<{@link String}>
	 * @param workflowType {@link WorkflowType}
	 * @param startDate {@link Date}
	 * @param endDate {@link Date}
	 * @param callback {@link AsyncCallback} < List < {@link Integer} > >
	 */
	void getTotalRowCount(List<String> batchClassIds, WorkflowType workflowType, Date startDate, Date endDate,
			AsyncCallback<Integer> callback);

	/**
	 * API to API to get Total Row Count for a user between the given startDate and endDate and list of batch class id's
	 * asynchronously.
	 * 
	 * @param batchClassIds List<{@link String}>
	 * @param user {@link String}
	 * @param startDate {@link Date}
	 * @param endDate {@link Date}
	 * @param callback {@link AsyncCallback} < List < {@link Integer} > >
	 */
	void getTotalRowCountForUser(List<String> batchClassIds, String user, Date startDate, Date endDate, AsyncCallback<Integer> callback);

	/**
	 * API to sync Database for reporting asynchronously.
	 * 
	 * @param callback {@link AsyncCallback} < List < {@link Void} > >
	 */
	void syncDatabase(AsyncCallback<Void> callback);
	/**
	 * API to get All Batch Classes for the given user, available in the form of map of identifier and it's description asynchronously.
	 * 
	 * @param callback {@link AsyncCallback} < List < Map<{@link String}, {@link String}> > >
	 * @param userName {String}
	 */
	void getAllBatchClassesForUserRoles(Set<String> userRoles,AsyncCallback<Map<String, String>> callback);

}
