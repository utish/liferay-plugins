/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.socialcoding.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.liferay.socialcoding.model.JIRAChangeGroup;
import com.liferay.socialcoding.model.JIRAChangeGroupModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the JIRAChangeGroup service. Represents a row in the &quot;changegroup&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link JIRAChangeGroupModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link JIRAChangeGroupImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see JIRAChangeGroupImpl
 * @see JIRAChangeGroup
 * @see JIRAChangeGroupModel
 * @generated
 */
@ProviderType
public class JIRAChangeGroupModelImpl extends BaseModelImpl<JIRAChangeGroup>
	implements JIRAChangeGroupModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a j i r a change group model instance should use the {@link JIRAChangeGroup} interface instead.
	 */
	public static final String TABLE_NAME = "changegroup";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", Types.BIGINT },
			{ "author", Types.VARCHAR },
			{ "created", Types.TIMESTAMP },
			{ "issueid", Types.BIGINT }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("author", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("created", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("issueid", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE = "create table changegroup (id LONG not null primary key,author VARCHAR(75) null,created DATE null,issueid LONG)";
	public static final String TABLE_SQL_DROP = "drop table changegroup";
	public static final String ORDER_BY_JPQL = " ORDER BY jiraChangeGroup.createDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY changegroup.created DESC";
	public static final String DATA_SOURCE = "jiraDataSource";
	public static final String SESSION_FACTORY = "jiraSessionFactory";
	public static final String TX_MANAGER = "jiraTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.socialcoding.model.JIRAChangeGroup"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.socialcoding.model.JIRAChangeGroup"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.socialcoding.model.JIRAChangeGroup"),
			true);
	public static final long JIRAISSUEID_COLUMN_BITMASK = 1L;
	public static final long JIRAUSERID_COLUMN_BITMASK = 2L;
	public static final long CREATEDATE_COLUMN_BITMASK = 4L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.socialcoding.model.JIRAChangeGroup"));

	public JIRAChangeGroupModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _jiraChangeGroupId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setJiraChangeGroupId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _jiraChangeGroupId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return JIRAChangeGroup.class;
	}

	@Override
	public String getModelClassName() {
		return JIRAChangeGroup.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("jiraChangeGroupId", getJiraChangeGroupId());
		attributes.put("jiraUserId", getJiraUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("jiraIssueId", getJiraIssueId());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long jiraChangeGroupId = (Long)attributes.get("jiraChangeGroupId");

		if (jiraChangeGroupId != null) {
			setJiraChangeGroupId(jiraChangeGroupId);
		}

		String jiraUserId = (String)attributes.get("jiraUserId");

		if (jiraUserId != null) {
			setJiraUserId(jiraUserId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long jiraIssueId = (Long)attributes.get("jiraIssueId");

		if (jiraIssueId != null) {
			setJiraIssueId(jiraIssueId);
		}
	}

	@Override
	public long getJiraChangeGroupId() {
		return _jiraChangeGroupId;
	}

	@Override
	public void setJiraChangeGroupId(long jiraChangeGroupId) {
		_jiraChangeGroupId = jiraChangeGroupId;
	}

	@Override
	public String getJiraUserId() {
		if (_jiraUserId == null) {
			return StringPool.BLANK;
		}
		else {
			return _jiraUserId;
		}
	}

	@Override
	public void setJiraUserId(String jiraUserId) {
		_columnBitmask |= JIRAUSERID_COLUMN_BITMASK;

		if (_originalJiraUserId == null) {
			_originalJiraUserId = _jiraUserId;
		}

		_jiraUserId = jiraUserId;
	}

	public String getOriginalJiraUserId() {
		return GetterUtil.getString(_originalJiraUserId);
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_columnBitmask = -1L;

		_createDate = createDate;
	}

	@Override
	public long getJiraIssueId() {
		return _jiraIssueId;
	}

	@Override
	public void setJiraIssueId(long jiraIssueId) {
		_columnBitmask |= JIRAISSUEID_COLUMN_BITMASK;

		if (!_setOriginalJiraIssueId) {
			_setOriginalJiraIssueId = true;

			_originalJiraIssueId = _jiraIssueId;
		}

		_jiraIssueId = jiraIssueId;
	}

	public long getOriginalJiraIssueId() {
		return _originalJiraIssueId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			JIRAChangeGroup.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public JIRAChangeGroup toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (JIRAChangeGroup)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		JIRAChangeGroupImpl jiraChangeGroupImpl = new JIRAChangeGroupImpl();

		jiraChangeGroupImpl.setJiraChangeGroupId(getJiraChangeGroupId());
		jiraChangeGroupImpl.setJiraUserId(getJiraUserId());
		jiraChangeGroupImpl.setCreateDate(getCreateDate());
		jiraChangeGroupImpl.setJiraIssueId(getJiraIssueId());

		jiraChangeGroupImpl.resetOriginalValues();

		return jiraChangeGroupImpl;
	}

	@Override
	public int compareTo(JIRAChangeGroup jiraChangeGroup) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(),
				jiraChangeGroup.getCreateDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof JIRAChangeGroup)) {
			return false;
		}

		JIRAChangeGroup jiraChangeGroup = (JIRAChangeGroup)obj;

		long primaryKey = jiraChangeGroup.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		JIRAChangeGroupModelImpl jiraChangeGroupModelImpl = this;

		jiraChangeGroupModelImpl._originalJiraUserId = jiraChangeGroupModelImpl._jiraUserId;

		jiraChangeGroupModelImpl._originalJiraIssueId = jiraChangeGroupModelImpl._jiraIssueId;

		jiraChangeGroupModelImpl._setOriginalJiraIssueId = false;

		jiraChangeGroupModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<JIRAChangeGroup> toCacheModel() {
		JIRAChangeGroupCacheModel jiraChangeGroupCacheModel = new JIRAChangeGroupCacheModel();

		jiraChangeGroupCacheModel.jiraChangeGroupId = getJiraChangeGroupId();

		jiraChangeGroupCacheModel.jiraUserId = getJiraUserId();

		String jiraUserId = jiraChangeGroupCacheModel.jiraUserId;

		if ((jiraUserId != null) && (jiraUserId.length() == 0)) {
			jiraChangeGroupCacheModel.jiraUserId = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			jiraChangeGroupCacheModel.createDate = createDate.getTime();
		}
		else {
			jiraChangeGroupCacheModel.createDate = Long.MIN_VALUE;
		}

		jiraChangeGroupCacheModel.jiraIssueId = getJiraIssueId();

		return jiraChangeGroupCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{jiraChangeGroupId=");
		sb.append(getJiraChangeGroupId());
		sb.append(", jiraUserId=");
		sb.append(getJiraUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", jiraIssueId=");
		sb.append(getJiraIssueId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.liferay.socialcoding.model.JIRAChangeGroup");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>jiraChangeGroupId</column-name><column-value><![CDATA[");
		sb.append(getJiraChangeGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jiraUserId</column-name><column-value><![CDATA[");
		sb.append(getJiraUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jiraIssueId</column-name><column-value><![CDATA[");
		sb.append(getJiraIssueId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = JIRAChangeGroup.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			JIRAChangeGroup.class
		};
	private long _jiraChangeGroupId;
	private String _jiraUserId;
	private String _originalJiraUserId;
	private Date _createDate;
	private long _jiraIssueId;
	private long _originalJiraIssueId;
	private boolean _setOriginalJiraIssueId;
	private long _columnBitmask;
	private JIRAChangeGroup _escapedModel;
}