package com.rundatop.sys.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChannelColumnsMemberExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ChannelColumnsMemberExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andChannelColumnsIdIsNull() {
            addCriterion("channel_columns_id is null");
            return (Criteria) this;
        }

        public Criteria andChannelColumnsIdIsNotNull() {
            addCriterion("channel_columns_id is not null");
            return (Criteria) this;
        }

        public Criteria andChannelColumnsIdEqualTo(String value) {
            addCriterion("channel_columns_id =", value, "channelColumnsId");
            return (Criteria) this;
        }

        public Criteria andChannelColumnsIdNotEqualTo(String value) {
            addCriterion("channel_columns_id <>", value, "channelColumnsId");
            return (Criteria) this;
        }

        public Criteria andChannelColumnsIdGreaterThan(String value) {
            addCriterion("channel_columns_id >", value, "channelColumnsId");
            return (Criteria) this;
        }

        public Criteria andChannelColumnsIdGreaterThanOrEqualTo(String value) {
            addCriterion("channel_columns_id >=", value, "channelColumnsId");
            return (Criteria) this;
        }

        public Criteria andChannelColumnsIdLessThan(String value) {
            addCriterion("channel_columns_id <", value, "channelColumnsId");
            return (Criteria) this;
        }

        public Criteria andChannelColumnsIdLessThanOrEqualTo(String value) {
            addCriterion("channel_columns_id <=", value, "channelColumnsId");
            return (Criteria) this;
        }

        public Criteria andChannelColumnsIdLike(String value) {
            addCriterion("channel_columns_id like", value, "channelColumnsId");
            return (Criteria) this;
        }

        public Criteria andChannelColumnsIdNotLike(String value) {
            addCriterion("channel_columns_id not like", value, "channelColumnsId");
            return (Criteria) this;
        }

        public Criteria andChannelColumnsIdIn(List<String> values) {
            addCriterion("channel_columns_id in", values, "channelColumnsId");
            return (Criteria) this;
        }

        public Criteria andChannelColumnsIdNotIn(List<String> values) {
            addCriterion("channel_columns_id not in", values, "channelColumnsId");
            return (Criteria) this;
        }

        public Criteria andChannelColumnsIdBetween(String value1, String value2) {
            addCriterion("channel_columns_id between", value1, value2, "channelColumnsId");
            return (Criteria) this;
        }

        public Criteria andChannelColumnsIdNotBetween(String value1, String value2) {
            addCriterion("channel_columns_id not between", value1, value2, "channelColumnsId");
            return (Criteria) this;
        }

        public Criteria andMemberGroupIdIsNull() {
            addCriterion("member_group_id is null");
            return (Criteria) this;
        }

        public Criteria andMemberGroupIdIsNotNull() {
            addCriterion("member_group_id is not null");
            return (Criteria) this;
        }

        public Criteria andMemberGroupIdEqualTo(String value) {
            addCriterion("member_group_id =", value, "memberGroupId");
            return (Criteria) this;
        }

        public Criteria andMemberGroupIdNotEqualTo(String value) {
            addCriterion("member_group_id <>", value, "memberGroupId");
            return (Criteria) this;
        }

        public Criteria andMemberGroupIdGreaterThan(String value) {
            addCriterion("member_group_id >", value, "memberGroupId");
            return (Criteria) this;
        }

        public Criteria andMemberGroupIdGreaterThanOrEqualTo(String value) {
            addCriterion("member_group_id >=", value, "memberGroupId");
            return (Criteria) this;
        }

        public Criteria andMemberGroupIdLessThan(String value) {
            addCriterion("member_group_id <", value, "memberGroupId");
            return (Criteria) this;
        }

        public Criteria andMemberGroupIdLessThanOrEqualTo(String value) {
            addCriterion("member_group_id <=", value, "memberGroupId");
            return (Criteria) this;
        }

        public Criteria andMemberGroupIdLike(String value) {
            addCriterion("member_group_id like", value, "memberGroupId");
            return (Criteria) this;
        }

        public Criteria andMemberGroupIdNotLike(String value) {
            addCriterion("member_group_id not like", value, "memberGroupId");
            return (Criteria) this;
        }

        public Criteria andMemberGroupIdIn(List<String> values) {
            addCriterion("member_group_id in", values, "memberGroupId");
            return (Criteria) this;
        }

        public Criteria andMemberGroupIdNotIn(List<String> values) {
            addCriterion("member_group_id not in", values, "memberGroupId");
            return (Criteria) this;
        }

        public Criteria andMemberGroupIdBetween(String value1, String value2) {
            addCriterion("member_group_id between", value1, value2, "memberGroupId");
            return (Criteria) this;
        }

        public Criteria andMemberGroupIdNotBetween(String value1, String value2) {
            addCriterion("member_group_id not between", value1, value2, "memberGroupId");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("remarks is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("remarks like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("remarks not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("remarks not between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreaterIdIsNull() {
            addCriterion("creater_id is null");
            return (Criteria) this;
        }

        public Criteria andCreaterIdIsNotNull() {
            addCriterion("creater_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreaterIdEqualTo(String value) {
            addCriterion("creater_id =", value, "createrId");
            return (Criteria) this;
        }

        public Criteria andCreaterIdNotEqualTo(String value) {
            addCriterion("creater_id <>", value, "createrId");
            return (Criteria) this;
        }

        public Criteria andCreaterIdGreaterThan(String value) {
            addCriterion("creater_id >", value, "createrId");
            return (Criteria) this;
        }

        public Criteria andCreaterIdGreaterThanOrEqualTo(String value) {
            addCriterion("creater_id >=", value, "createrId");
            return (Criteria) this;
        }

        public Criteria andCreaterIdLessThan(String value) {
            addCriterion("creater_id <", value, "createrId");
            return (Criteria) this;
        }

        public Criteria andCreaterIdLessThanOrEqualTo(String value) {
            addCriterion("creater_id <=", value, "createrId");
            return (Criteria) this;
        }

        public Criteria andCreaterIdLike(String value) {
            addCriterion("creater_id like", value, "createrId");
            return (Criteria) this;
        }

        public Criteria andCreaterIdNotLike(String value) {
            addCriterion("creater_id not like", value, "createrId");
            return (Criteria) this;
        }

        public Criteria andCreaterIdIn(List<String> values) {
            addCriterion("creater_id in", values, "createrId");
            return (Criteria) this;
        }

        public Criteria andCreaterIdNotIn(List<String> values) {
            addCriterion("creater_id not in", values, "createrId");
            return (Criteria) this;
        }

        public Criteria andCreaterIdBetween(String value1, String value2) {
            addCriterion("creater_id between", value1, value2, "createrId");
            return (Criteria) this;
        }

        public Criteria andCreaterIdNotBetween(String value1, String value2) {
            addCriterion("creater_id not between", value1, value2, "createrId");
            return (Criteria) this;
        }

        public Criteria andFree1IsNull() {
            addCriterion("free1 is null");
            return (Criteria) this;
        }

        public Criteria andFree1IsNotNull() {
            addCriterion("free1 is not null");
            return (Criteria) this;
        }

        public Criteria andFree1EqualTo(String value) {
            addCriterion("free1 =", value, "free1");
            return (Criteria) this;
        }

        public Criteria andFree1NotEqualTo(String value) {
            addCriterion("free1 <>", value, "free1");
            return (Criteria) this;
        }

        public Criteria andFree1GreaterThan(String value) {
            addCriterion("free1 >", value, "free1");
            return (Criteria) this;
        }

        public Criteria andFree1GreaterThanOrEqualTo(String value) {
            addCriterion("free1 >=", value, "free1");
            return (Criteria) this;
        }

        public Criteria andFree1LessThan(String value) {
            addCriterion("free1 <", value, "free1");
            return (Criteria) this;
        }

        public Criteria andFree1LessThanOrEqualTo(String value) {
            addCriterion("free1 <=", value, "free1");
            return (Criteria) this;
        }

        public Criteria andFree1Like(String value) {
            addCriterion("free1 like", value, "free1");
            return (Criteria) this;
        }

        public Criteria andFree1NotLike(String value) {
            addCriterion("free1 not like", value, "free1");
            return (Criteria) this;
        }

        public Criteria andFree1In(List<String> values) {
            addCriterion("free1 in", values, "free1");
            return (Criteria) this;
        }

        public Criteria andFree1NotIn(List<String> values) {
            addCriterion("free1 not in", values, "free1");
            return (Criteria) this;
        }

        public Criteria andFree1Between(String value1, String value2) {
            addCriterion("free1 between", value1, value2, "free1");
            return (Criteria) this;
        }

        public Criteria andFree1NotBetween(String value1, String value2) {
            addCriterion("free1 not between", value1, value2, "free1");
            return (Criteria) this;
        }

        public Criteria andFree2IsNull() {
            addCriterion("free2 is null");
            return (Criteria) this;
        }

        public Criteria andFree2IsNotNull() {
            addCriterion("free2 is not null");
            return (Criteria) this;
        }

        public Criteria andFree2EqualTo(String value) {
            addCriterion("free2 =", value, "free2");
            return (Criteria) this;
        }

        public Criteria andFree2NotEqualTo(String value) {
            addCriterion("free2 <>", value, "free2");
            return (Criteria) this;
        }

        public Criteria andFree2GreaterThan(String value) {
            addCriterion("free2 >", value, "free2");
            return (Criteria) this;
        }

        public Criteria andFree2GreaterThanOrEqualTo(String value) {
            addCriterion("free2 >=", value, "free2");
            return (Criteria) this;
        }

        public Criteria andFree2LessThan(String value) {
            addCriterion("free2 <", value, "free2");
            return (Criteria) this;
        }

        public Criteria andFree2LessThanOrEqualTo(String value) {
            addCriterion("free2 <=", value, "free2");
            return (Criteria) this;
        }

        public Criteria andFree2Like(String value) {
            addCriterion("free2 like", value, "free2");
            return (Criteria) this;
        }

        public Criteria andFree2NotLike(String value) {
            addCriterion("free2 not like", value, "free2");
            return (Criteria) this;
        }

        public Criteria andFree2In(List<String> values) {
            addCriterion("free2 in", values, "free2");
            return (Criteria) this;
        }

        public Criteria andFree2NotIn(List<String> values) {
            addCriterion("free2 not in", values, "free2");
            return (Criteria) this;
        }

        public Criteria andFree2Between(String value1, String value2) {
            addCriterion("free2 between", value1, value2, "free2");
            return (Criteria) this;
        }

        public Criteria andFree2NotBetween(String value1, String value2) {
            addCriterion("free2 not between", value1, value2, "free2");
            return (Criteria) this;
        }

        public Criteria andFree3IsNull() {
            addCriterion("free3 is null");
            return (Criteria) this;
        }

        public Criteria andFree3IsNotNull() {
            addCriterion("free3 is not null");
            return (Criteria) this;
        }

        public Criteria andFree3EqualTo(String value) {
            addCriterion("free3 =", value, "free3");
            return (Criteria) this;
        }

        public Criteria andFree3NotEqualTo(String value) {
            addCriterion("free3 <>", value, "free3");
            return (Criteria) this;
        }

        public Criteria andFree3GreaterThan(String value) {
            addCriterion("free3 >", value, "free3");
            return (Criteria) this;
        }

        public Criteria andFree3GreaterThanOrEqualTo(String value) {
            addCriterion("free3 >=", value, "free3");
            return (Criteria) this;
        }

        public Criteria andFree3LessThan(String value) {
            addCriterion("free3 <", value, "free3");
            return (Criteria) this;
        }

        public Criteria andFree3LessThanOrEqualTo(String value) {
            addCriterion("free3 <=", value, "free3");
            return (Criteria) this;
        }

        public Criteria andFree3Like(String value) {
            addCriterion("free3 like", value, "free3");
            return (Criteria) this;
        }

        public Criteria andFree3NotLike(String value) {
            addCriterion("free3 not like", value, "free3");
            return (Criteria) this;
        }

        public Criteria andFree3In(List<String> values) {
            addCriterion("free3 in", values, "free3");
            return (Criteria) this;
        }

        public Criteria andFree3NotIn(List<String> values) {
            addCriterion("free3 not in", values, "free3");
            return (Criteria) this;
        }

        public Criteria andFree3Between(String value1, String value2) {
            addCriterion("free3 between", value1, value2, "free3");
            return (Criteria) this;
        }

        public Criteria andFree3NotBetween(String value1, String value2) {
            addCriterion("free3 not between", value1, value2, "free3");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}