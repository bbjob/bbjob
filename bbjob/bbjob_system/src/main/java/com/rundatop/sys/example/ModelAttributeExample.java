package com.rundatop.sys.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ModelAttributeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ModelAttributeExample() {
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

        public Criteria andClumnIdIsNull() {
            addCriterion("clumn_id is null");
            return (Criteria) this;
        }

        public Criteria andClumnIdIsNotNull() {
            addCriterion("clumn_id is not null");
            return (Criteria) this;
        }

        public Criteria andClumnIdEqualTo(String value) {
            addCriterion("clumn_id =", value, "clumnId");
            return (Criteria) this;
        }

        public Criteria andClumnIdNotEqualTo(String value) {
            addCriterion("clumn_id <>", value, "clumnId");
            return (Criteria) this;
        }

        public Criteria andClumnIdGreaterThan(String value) {
            addCriterion("clumn_id >", value, "clumnId");
            return (Criteria) this;
        }

        public Criteria andClumnIdGreaterThanOrEqualTo(String value) {
            addCriterion("clumn_id >=", value, "clumnId");
            return (Criteria) this;
        }

        public Criteria andClumnIdLessThan(String value) {
            addCriterion("clumn_id <", value, "clumnId");
            return (Criteria) this;
        }

        public Criteria andClumnIdLessThanOrEqualTo(String value) {
            addCriterion("clumn_id <=", value, "clumnId");
            return (Criteria) this;
        }

        public Criteria andClumnIdLike(String value) {
            addCriterion("clumn_id like", value, "clumnId");
            return (Criteria) this;
        }

        public Criteria andClumnIdNotLike(String value) {
            addCriterion("clumn_id not like", value, "clumnId");
            return (Criteria) this;
        }

        public Criteria andClumnIdIn(List<String> values) {
            addCriterion("clumn_id in", values, "clumnId");
            return (Criteria) this;
        }

        public Criteria andClumnIdNotIn(List<String> values) {
            addCriterion("clumn_id not in", values, "clumnId");
            return (Criteria) this;
        }

        public Criteria andClumnIdBetween(String value1, String value2) {
            addCriterion("clumn_id between", value1, value2, "clumnId");
            return (Criteria) this;
        }

        public Criteria andClumnIdNotBetween(String value1, String value2) {
            addCriterion("clumn_id not between", value1, value2, "clumnId");
            return (Criteria) this;
        }

        public Criteria andArticleNumberIsNull() {
            addCriterion("article_number is null");
            return (Criteria) this;
        }

        public Criteria andArticleNumberIsNotNull() {
            addCriterion("article_number is not null");
            return (Criteria) this;
        }

        public Criteria andArticleNumberEqualTo(String value) {
            addCriterion("article_number =", value, "articleNumber");
            return (Criteria) this;
        }

        public Criteria andArticleNumberNotEqualTo(String value) {
            addCriterion("article_number <>", value, "articleNumber");
            return (Criteria) this;
        }

        public Criteria andArticleNumberGreaterThan(String value) {
            addCriterion("article_number >", value, "articleNumber");
            return (Criteria) this;
        }

        public Criteria andArticleNumberGreaterThanOrEqualTo(String value) {
            addCriterion("article_number >=", value, "articleNumber");
            return (Criteria) this;
        }

        public Criteria andArticleNumberLessThan(String value) {
            addCriterion("article_number <", value, "articleNumber");
            return (Criteria) this;
        }

        public Criteria andArticleNumberLessThanOrEqualTo(String value) {
            addCriterion("article_number <=", value, "articleNumber");
            return (Criteria) this;
        }

        public Criteria andArticleNumberLike(String value) {
            addCriterion("article_number like", value, "articleNumber");
            return (Criteria) this;
        }

        public Criteria andArticleNumberNotLike(String value) {
            addCriterion("article_number not like", value, "articleNumber");
            return (Criteria) this;
        }

        public Criteria andArticleNumberIn(List<String> values) {
            addCriterion("article_number in", values, "articleNumber");
            return (Criteria) this;
        }

        public Criteria andArticleNumberNotIn(List<String> values) {
            addCriterion("article_number not in", values, "articleNumber");
            return (Criteria) this;
        }

        public Criteria andArticleNumberBetween(String value1, String value2) {
            addCriterion("article_number between", value1, value2, "articleNumber");
            return (Criteria) this;
        }

        public Criteria andArticleNumberNotBetween(String value1, String value2) {
            addCriterion("article_number not between", value1, value2, "articleNumber");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
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

        public Criteria andCreateNameIsNull() {
            addCriterion("create_name is null");
            return (Criteria) this;
        }

        public Criteria andCreateNameIsNotNull() {
            addCriterion("create_name is not null");
            return (Criteria) this;
        }

        public Criteria andCreateNameEqualTo(String value) {
            addCriterion("create_name =", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameNotEqualTo(String value) {
            addCriterion("create_name <>", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameGreaterThan(String value) {
            addCriterion("create_name >", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameGreaterThanOrEqualTo(String value) {
            addCriterion("create_name >=", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameLessThan(String value) {
            addCriterion("create_name <", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameLessThanOrEqualTo(String value) {
            addCriterion("create_name <=", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameLike(String value) {
            addCriterion("create_name like", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameNotLike(String value) {
            addCriterion("create_name not like", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameIn(List<String> values) {
            addCriterion("create_name in", values, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameNotIn(List<String> values) {
            addCriterion("create_name not in", values, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameBetween(String value1, String value2) {
            addCriterion("create_name between", value1, value2, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameNotBetween(String value1, String value2) {
            addCriterion("create_name not between", value1, value2, "createName");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateNameIsNull() {
            addCriterion("update_name is null");
            return (Criteria) this;
        }

        public Criteria andUpdateNameIsNotNull() {
            addCriterion("update_name is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateNameEqualTo(String value) {
            addCriterion("update_name =", value, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateNameNotEqualTo(String value) {
            addCriterion("update_name <>", value, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateNameGreaterThan(String value) {
            addCriterion("update_name >", value, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateNameGreaterThanOrEqualTo(String value) {
            addCriterion("update_name >=", value, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateNameLessThan(String value) {
            addCriterion("update_name <", value, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateNameLessThanOrEqualTo(String value) {
            addCriterion("update_name <=", value, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateNameLike(String value) {
            addCriterion("update_name like", value, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateNameNotLike(String value) {
            addCriterion("update_name not like", value, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateNameIn(List<String> values) {
            addCriterion("update_name in", values, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateNameNotIn(List<String> values) {
            addCriterion("update_name not in", values, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateNameBetween(String value1, String value2) {
            addCriterion("update_name between", value1, value2, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateNameNotBetween(String value1, String value2) {
            addCriterion("update_name not between", value1, value2, "updateName");
            return (Criteria) this;
        }

        public Criteria andF1IsNull() {
            addCriterion("f1 is null");
            return (Criteria) this;
        }

        public Criteria andF1IsNotNull() {
            addCriterion("f1 is not null");
            return (Criteria) this;
        }

        public Criteria andF1EqualTo(String value) {
            addCriterion("f1 =", value, "f1");
            return (Criteria) this;
        }

        public Criteria andF1NotEqualTo(String value) {
            addCriterion("f1 <>", value, "f1");
            return (Criteria) this;
        }

        public Criteria andF1GreaterThan(String value) {
            addCriterion("f1 >", value, "f1");
            return (Criteria) this;
        }

        public Criteria andF1GreaterThanOrEqualTo(String value) {
            addCriterion("f1 >=", value, "f1");
            return (Criteria) this;
        }

        public Criteria andF1LessThan(String value) {
            addCriterion("f1 <", value, "f1");
            return (Criteria) this;
        }

        public Criteria andF1LessThanOrEqualTo(String value) {
            addCriterion("f1 <=", value, "f1");
            return (Criteria) this;
        }

        public Criteria andF1Like(String value) {
            addCriterion("f1 like", value, "f1");
            return (Criteria) this;
        }

        public Criteria andF1NotLike(String value) {
            addCriterion("f1 not like", value, "f1");
            return (Criteria) this;
        }

        public Criteria andF1In(List<String> values) {
            addCriterion("f1 in", values, "f1");
            return (Criteria) this;
        }

        public Criteria andF1NotIn(List<String> values) {
            addCriterion("f1 not in", values, "f1");
            return (Criteria) this;
        }

        public Criteria andF1Between(String value1, String value2) {
            addCriterion("f1 between", value1, value2, "f1");
            return (Criteria) this;
        }

        public Criteria andF1NotBetween(String value1, String value2) {
            addCriterion("f1 not between", value1, value2, "f1");
            return (Criteria) this;
        }

        public Criteria andF2IsNull() {
            addCriterion("f2 is null");
            return (Criteria) this;
        }

        public Criteria andF2IsNotNull() {
            addCriterion("f2 is not null");
            return (Criteria) this;
        }

        public Criteria andF2EqualTo(String value) {
            addCriterion("f2 =", value, "f2");
            return (Criteria) this;
        }

        public Criteria andF2NotEqualTo(String value) {
            addCriterion("f2 <>", value, "f2");
            return (Criteria) this;
        }

        public Criteria andF2GreaterThan(String value) {
            addCriterion("f2 >", value, "f2");
            return (Criteria) this;
        }

        public Criteria andF2GreaterThanOrEqualTo(String value) {
            addCriterion("f2 >=", value, "f2");
            return (Criteria) this;
        }

        public Criteria andF2LessThan(String value) {
            addCriterion("f2 <", value, "f2");
            return (Criteria) this;
        }

        public Criteria andF2LessThanOrEqualTo(String value) {
            addCriterion("f2 <=", value, "f2");
            return (Criteria) this;
        }

        public Criteria andF2Like(String value) {
            addCriterion("f2 like", value, "f2");
            return (Criteria) this;
        }

        public Criteria andF2NotLike(String value) {
            addCriterion("f2 not like", value, "f2");
            return (Criteria) this;
        }

        public Criteria andF2In(List<String> values) {
            addCriterion("f2 in", values, "f2");
            return (Criteria) this;
        }

        public Criteria andF2NotIn(List<String> values) {
            addCriterion("f2 not in", values, "f2");
            return (Criteria) this;
        }

        public Criteria andF2Between(String value1, String value2) {
            addCriterion("f2 between", value1, value2, "f2");
            return (Criteria) this;
        }

        public Criteria andF2NotBetween(String value1, String value2) {
            addCriterion("f2 not between", value1, value2, "f2");
            return (Criteria) this;
        }

        public Criteria andF3IsNull() {
            addCriterion("f3 is null");
            return (Criteria) this;
        }

        public Criteria andF3IsNotNull() {
            addCriterion("f3 is not null");
            return (Criteria) this;
        }

        public Criteria andF3EqualTo(Integer value) {
            addCriterion("f3 =", value, "f3");
            return (Criteria) this;
        }

        public Criteria andF3NotEqualTo(Integer value) {
            addCriterion("f3 <>", value, "f3");
            return (Criteria) this;
        }

        public Criteria andF3GreaterThan(Integer value) {
            addCriterion("f3 >", value, "f3");
            return (Criteria) this;
        }

        public Criteria andF3GreaterThanOrEqualTo(Integer value) {
            addCriterion("f3 >=", value, "f3");
            return (Criteria) this;
        }

        public Criteria andF3LessThan(Integer value) {
            addCriterion("f3 <", value, "f3");
            return (Criteria) this;
        }

        public Criteria andF3LessThanOrEqualTo(Integer value) {
            addCriterion("f3 <=", value, "f3");
            return (Criteria) this;
        }

        public Criteria andF3In(List<Integer> values) {
            addCriterion("f3 in", values, "f3");
            return (Criteria) this;
        }

        public Criteria andF3NotIn(List<Integer> values) {
            addCriterion("f3 not in", values, "f3");
            return (Criteria) this;
        }

        public Criteria andF3Between(Integer value1, Integer value2) {
            addCriterion("f3 between", value1, value2, "f3");
            return (Criteria) this;
        }

        public Criteria andF3NotBetween(Integer value1, Integer value2) {
            addCriterion("f3 not between", value1, value2, "f3");
            return (Criteria) this;
        }

        public Criteria andF4IsNull() {
            addCriterion("f4 is null");
            return (Criteria) this;
        }

        public Criteria andF4IsNotNull() {
            addCriterion("f4 is not null");
            return (Criteria) this;
        }

        public Criteria andF4EqualTo(String value) {
            addCriterion("f4 =", value, "f4");
            return (Criteria) this;
        }

        public Criteria andF4NotEqualTo(String value) {
            addCriterion("f4 <>", value, "f4");
            return (Criteria) this;
        }

        public Criteria andF4GreaterThan(String value) {
            addCriterion("f4 >", value, "f4");
            return (Criteria) this;
        }

        public Criteria andF4GreaterThanOrEqualTo(String value) {
            addCriterion("f4 >=", value, "f4");
            return (Criteria) this;
        }

        public Criteria andF4LessThan(String value) {
            addCriterion("f4 <", value, "f4");
            return (Criteria) this;
        }

        public Criteria andF4LessThanOrEqualTo(String value) {
            addCriterion("f4 <=", value, "f4");
            return (Criteria) this;
        }

        public Criteria andF4Like(String value) {
            addCriterion("f4 like", value, "f4");
            return (Criteria) this;
        }

        public Criteria andF4NotLike(String value) {
            addCriterion("f4 not like", value, "f4");
            return (Criteria) this;
        }

        public Criteria andF4In(List<String> values) {
            addCriterion("f4 in", values, "f4");
            return (Criteria) this;
        }

        public Criteria andF4NotIn(List<String> values) {
            addCriterion("f4 not in", values, "f4");
            return (Criteria) this;
        }

        public Criteria andF4Between(String value1, String value2) {
            addCriterion("f4 between", value1, value2, "f4");
            return (Criteria) this;
        }

        public Criteria andF4NotBetween(String value1, String value2) {
            addCriterion("f4 not between", value1, value2, "f4");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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

        public Criteria andArticleTypeIsNull() {
            addCriterion("article_type is null");
            return (Criteria) this;
        }

        public Criteria andArticleTypeIsNotNull() {
            addCriterion("article_type is not null");
            return (Criteria) this;
        }

        public Criteria andArticleTypeEqualTo(String value) {
            addCriterion("article_type =", value, "articleType");
            return (Criteria) this;
        }

        public Criteria andArticleTypeNotEqualTo(String value) {
            addCriterion("article_type <>", value, "articleType");
            return (Criteria) this;
        }

        public Criteria andArticleTypeGreaterThan(String value) {
            addCriterion("article_type >", value, "articleType");
            return (Criteria) this;
        }

        public Criteria andArticleTypeGreaterThanOrEqualTo(String value) {
            addCriterion("article_type >=", value, "articleType");
            return (Criteria) this;
        }

        public Criteria andArticleTypeLessThan(String value) {
            addCriterion("article_type <", value, "articleType");
            return (Criteria) this;
        }

        public Criteria andArticleTypeLessThanOrEqualTo(String value) {
            addCriterion("article_type <=", value, "articleType");
            return (Criteria) this;
        }

        public Criteria andArticleTypeLike(String value) {
            addCriterion("article_type like", value, "articleType");
            return (Criteria) this;
        }

        public Criteria andArticleTypeNotLike(String value) {
            addCriterion("article_type not like", value, "articleType");
            return (Criteria) this;
        }

        public Criteria andArticleTypeIn(List<String> values) {
            addCriterion("article_type in", values, "articleType");
            return (Criteria) this;
        }

        public Criteria andArticleTypeNotIn(List<String> values) {
            addCriterion("article_type not in", values, "articleType");
            return (Criteria) this;
        }

        public Criteria andArticleTypeBetween(String value1, String value2) {
            addCriterion("article_type between", value1, value2, "articleType");
            return (Criteria) this;
        }

        public Criteria andArticleTypeNotBetween(String value1, String value2) {
            addCriterion("article_type not between", value1, value2, "articleType");
            return (Criteria) this;
        }

        public Criteria andLineNumberIsNull() {
            addCriterion("line_number is null");
            return (Criteria) this;
        }

        public Criteria andLineNumberIsNotNull() {
            addCriterion("line_number is not null");
            return (Criteria) this;
        }

        public Criteria andLineNumberEqualTo(Integer value) {
            addCriterion("line_number =", value, "lineNumber");
            return (Criteria) this;
        }

        public Criteria andLineNumberNotEqualTo(Integer value) {
            addCriterion("line_number <>", value, "lineNumber");
            return (Criteria) this;
        }

        public Criteria andLineNumberGreaterThan(Integer value) {
            addCriterion("line_number >", value, "lineNumber");
            return (Criteria) this;
        }

        public Criteria andLineNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("line_number >=", value, "lineNumber");
            return (Criteria) this;
        }

        public Criteria andLineNumberLessThan(Integer value) {
            addCriterion("line_number <", value, "lineNumber");
            return (Criteria) this;
        }

        public Criteria andLineNumberLessThanOrEqualTo(Integer value) {
            addCriterion("line_number <=", value, "lineNumber");
            return (Criteria) this;
        }

        public Criteria andLineNumberIn(List<Integer> values) {
            addCriterion("line_number in", values, "lineNumber");
            return (Criteria) this;
        }

        public Criteria andLineNumberNotIn(List<Integer> values) {
            addCriterion("line_number not in", values, "lineNumber");
            return (Criteria) this;
        }

        public Criteria andLineNumberBetween(Integer value1, Integer value2) {
            addCriterion("line_number between", value1, value2, "lineNumber");
            return (Criteria) this;
        }

        public Criteria andLineNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("line_number not between", value1, value2, "lineNumber");
            return (Criteria) this;
        }

        public Criteria andTimeTypeIsNull() {
            addCriterion("time_type is null");
            return (Criteria) this;
        }

        public Criteria andTimeTypeIsNotNull() {
            addCriterion("time_type is not null");
            return (Criteria) this;
        }

        public Criteria andTimeTypeEqualTo(Integer value) {
            addCriterion("time_type =", value, "timeType");
            return (Criteria) this;
        }

        public Criteria andTimeTypeNotEqualTo(Integer value) {
            addCriterion("time_type <>", value, "timeType");
            return (Criteria) this;
        }

        public Criteria andTimeTypeGreaterThan(Integer value) {
            addCriterion("time_type >", value, "timeType");
            return (Criteria) this;
        }

        public Criteria andTimeTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("time_type >=", value, "timeType");
            return (Criteria) this;
        }

        public Criteria andTimeTypeLessThan(Integer value) {
            addCriterion("time_type <", value, "timeType");
            return (Criteria) this;
        }

        public Criteria andTimeTypeLessThanOrEqualTo(Integer value) {
            addCriterion("time_type <=", value, "timeType");
            return (Criteria) this;
        }

        public Criteria andTimeTypeIn(List<Integer> values) {
            addCriterion("time_type in", values, "timeType");
            return (Criteria) this;
        }

        public Criteria andTimeTypeNotIn(List<Integer> values) {
            addCriterion("time_type not in", values, "timeType");
            return (Criteria) this;
        }

        public Criteria andTimeTypeBetween(Integer value1, Integer value2) {
            addCriterion("time_type between", value1, value2, "timeType");
            return (Criteria) this;
        }

        public Criteria andTimeTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("time_type not between", value1, value2, "timeType");
            return (Criteria) this;
        }

        public Criteria andDisplayConentIsNull() {
            addCriterion("display_conent is null");
            return (Criteria) this;
        }

        public Criteria andDisplayConentIsNotNull() {
            addCriterion("display_conent is not null");
            return (Criteria) this;
        }

        public Criteria andDisplayConentEqualTo(String value) {
            addCriterion("display_conent =", value, "displayConent");
            return (Criteria) this;
        }

        public Criteria andDisplayConentNotEqualTo(String value) {
            addCriterion("display_conent <>", value, "displayConent");
            return (Criteria) this;
        }

        public Criteria andDisplayConentGreaterThan(String value) {
            addCriterion("display_conent >", value, "displayConent");
            return (Criteria) this;
        }

        public Criteria andDisplayConentGreaterThanOrEqualTo(String value) {
            addCriterion("display_conent >=", value, "displayConent");
            return (Criteria) this;
        }

        public Criteria andDisplayConentLessThan(String value) {
            addCriterion("display_conent <", value, "displayConent");
            return (Criteria) this;
        }

        public Criteria andDisplayConentLessThanOrEqualTo(String value) {
            addCriterion("display_conent <=", value, "displayConent");
            return (Criteria) this;
        }

        public Criteria andDisplayConentLike(String value) {
            addCriterion("display_conent like", value, "displayConent");
            return (Criteria) this;
        }

        public Criteria andDisplayConentNotLike(String value) {
            addCriterion("display_conent not like", value, "displayConent");
            return (Criteria) this;
        }

        public Criteria andDisplayConentIn(List<String> values) {
            addCriterion("display_conent in", values, "displayConent");
            return (Criteria) this;
        }

        public Criteria andDisplayConentNotIn(List<String> values) {
            addCriterion("display_conent not in", values, "displayConent");
            return (Criteria) this;
        }

        public Criteria andDisplayConentBetween(String value1, String value2) {
            addCriterion("display_conent between", value1, value2, "displayConent");
            return (Criteria) this;
        }

        public Criteria andDisplayConentNotBetween(String value1, String value2) {
            addCriterion("display_conent not between", value1, value2, "displayConent");
            return (Criteria) this;
        }

        public Criteria andSortTypeIsNull() {
            addCriterion("sort_type is null");
            return (Criteria) this;
        }

        public Criteria andSortTypeIsNotNull() {
            addCriterion("sort_type is not null");
            return (Criteria) this;
        }

        public Criteria andSortTypeEqualTo(Integer value) {
            addCriterion("sort_type =", value, "sortType");
            return (Criteria) this;
        }

        public Criteria andSortTypeNotEqualTo(Integer value) {
            addCriterion("sort_type <>", value, "sortType");
            return (Criteria) this;
        }

        public Criteria andSortTypeGreaterThan(Integer value) {
            addCriterion("sort_type >", value, "sortType");
            return (Criteria) this;
        }

        public Criteria andSortTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort_type >=", value, "sortType");
            return (Criteria) this;
        }

        public Criteria andSortTypeLessThan(Integer value) {
            addCriterion("sort_type <", value, "sortType");
            return (Criteria) this;
        }

        public Criteria andSortTypeLessThanOrEqualTo(Integer value) {
            addCriterion("sort_type <=", value, "sortType");
            return (Criteria) this;
        }

        public Criteria andSortTypeIn(List<Integer> values) {
            addCriterion("sort_type in", values, "sortType");
            return (Criteria) this;
        }

        public Criteria andSortTypeNotIn(List<Integer> values) {
            addCriterion("sort_type not in", values, "sortType");
            return (Criteria) this;
        }

        public Criteria andSortTypeBetween(Integer value1, Integer value2) {
            addCriterion("sort_type between", value1, value2, "sortType");
            return (Criteria) this;
        }

        public Criteria andSortTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("sort_type not between", value1, value2, "sortType");
            return (Criteria) this;
        }

        public Criteria andTitleLengthIsNull() {
            addCriterion("title_length is null");
            return (Criteria) this;
        }

        public Criteria andTitleLengthIsNotNull() {
            addCriterion("title_length is not null");
            return (Criteria) this;
        }

        public Criteria andTitleLengthEqualTo(String value) {
            addCriterion("title_length =", value, "titleLength");
            return (Criteria) this;
        }

        public Criteria andTitleLengthNotEqualTo(String value) {
            addCriterion("title_length <>", value, "titleLength");
            return (Criteria) this;
        }

        public Criteria andTitleLengthGreaterThan(String value) {
            addCriterion("title_length >", value, "titleLength");
            return (Criteria) this;
        }

        public Criteria andTitleLengthGreaterThanOrEqualTo(String value) {
            addCriterion("title_length >=", value, "titleLength");
            return (Criteria) this;
        }

        public Criteria andTitleLengthLessThan(String value) {
            addCriterion("title_length <", value, "titleLength");
            return (Criteria) this;
        }

        public Criteria andTitleLengthLessThanOrEqualTo(String value) {
            addCriterion("title_length <=", value, "titleLength");
            return (Criteria) this;
        }

        public Criteria andTitleLengthLike(String value) {
            addCriterion("title_length like", value, "titleLength");
            return (Criteria) this;
        }

        public Criteria andTitleLengthNotLike(String value) {
            addCriterion("title_length not like", value, "titleLength");
            return (Criteria) this;
        }

        public Criteria andTitleLengthIn(List<String> values) {
            addCriterion("title_length in", values, "titleLength");
            return (Criteria) this;
        }

        public Criteria andTitleLengthNotIn(List<String> values) {
            addCriterion("title_length not in", values, "titleLength");
            return (Criteria) this;
        }

        public Criteria andTitleLengthBetween(String value1, String value2) {
            addCriterion("title_length between", value1, value2, "titleLength");
            return (Criteria) this;
        }

        public Criteria andTitleLengthNotBetween(String value1, String value2) {
            addCriterion("title_length not between", value1, value2, "titleLength");
            return (Criteria) this;
        }

        public Criteria andTitleLineNumberIsNull() {
            addCriterion("title_line_number is null");
            return (Criteria) this;
        }

        public Criteria andTitleLineNumberIsNotNull() {
            addCriterion("title_line_number is not null");
            return (Criteria) this;
        }

        public Criteria andTitleLineNumberEqualTo(String value) {
            addCriterion("title_line_number =", value, "titleLineNumber");
            return (Criteria) this;
        }

        public Criteria andTitleLineNumberNotEqualTo(String value) {
            addCriterion("title_line_number <>", value, "titleLineNumber");
            return (Criteria) this;
        }

        public Criteria andTitleLineNumberGreaterThan(String value) {
            addCriterion("title_line_number >", value, "titleLineNumber");
            return (Criteria) this;
        }

        public Criteria andTitleLineNumberGreaterThanOrEqualTo(String value) {
            addCriterion("title_line_number >=", value, "titleLineNumber");
            return (Criteria) this;
        }

        public Criteria andTitleLineNumberLessThan(String value) {
            addCriterion("title_line_number <", value, "titleLineNumber");
            return (Criteria) this;
        }

        public Criteria andTitleLineNumberLessThanOrEqualTo(String value) {
            addCriterion("title_line_number <=", value, "titleLineNumber");
            return (Criteria) this;
        }

        public Criteria andTitleLineNumberLike(String value) {
            addCriterion("title_line_number like", value, "titleLineNumber");
            return (Criteria) this;
        }

        public Criteria andTitleLineNumberNotLike(String value) {
            addCriterion("title_line_number not like", value, "titleLineNumber");
            return (Criteria) this;
        }

        public Criteria andTitleLineNumberIn(List<String> values) {
            addCriterion("title_line_number in", values, "titleLineNumber");
            return (Criteria) this;
        }

        public Criteria andTitleLineNumberNotIn(List<String> values) {
            addCriterion("title_line_number not in", values, "titleLineNumber");
            return (Criteria) this;
        }

        public Criteria andTitleLineNumberBetween(String value1, String value2) {
            addCriterion("title_line_number between", value1, value2, "titleLineNumber");
            return (Criteria) this;
        }

        public Criteria andTitleLineNumberNotBetween(String value1, String value2) {
            addCriterion("title_line_number not between", value1, value2, "titleLineNumber");
            return (Criteria) this;
        }

        public Criteria andPrefixTypeIsNull() {
            addCriterion("prefix_type is null");
            return (Criteria) this;
        }

        public Criteria andPrefixTypeIsNotNull() {
            addCriterion("prefix_type is not null");
            return (Criteria) this;
        }

        public Criteria andPrefixTypeEqualTo(Integer value) {
            addCriterion("prefix_type =", value, "prefixType");
            return (Criteria) this;
        }

        public Criteria andPrefixTypeNotEqualTo(Integer value) {
            addCriterion("prefix_type <>", value, "prefixType");
            return (Criteria) this;
        }

        public Criteria andPrefixTypeGreaterThan(Integer value) {
            addCriterion("prefix_type >", value, "prefixType");
            return (Criteria) this;
        }

        public Criteria andPrefixTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("prefix_type >=", value, "prefixType");
            return (Criteria) this;
        }

        public Criteria andPrefixTypeLessThan(Integer value) {
            addCriterion("prefix_type <", value, "prefixType");
            return (Criteria) this;
        }

        public Criteria andPrefixTypeLessThanOrEqualTo(Integer value) {
            addCriterion("prefix_type <=", value, "prefixType");
            return (Criteria) this;
        }

        public Criteria andPrefixTypeIn(List<Integer> values) {
            addCriterion("prefix_type in", values, "prefixType");
            return (Criteria) this;
        }

        public Criteria andPrefixTypeNotIn(List<Integer> values) {
            addCriterion("prefix_type not in", values, "prefixType");
            return (Criteria) this;
        }

        public Criteria andPrefixTypeBetween(Integer value1, Integer value2) {
            addCriterion("prefix_type between", value1, value2, "prefixType");
            return (Criteria) this;
        }

        public Criteria andPrefixTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("prefix_type not between", value1, value2, "prefixType");
            return (Criteria) this;
        }

        public Criteria andPrefixContentIsNull() {
            addCriterion("prefix_content is null");
            return (Criteria) this;
        }

        public Criteria andPrefixContentIsNotNull() {
            addCriterion("prefix_content is not null");
            return (Criteria) this;
        }

        public Criteria andPrefixContentEqualTo(String value) {
            addCriterion("prefix_content =", value, "prefixContent");
            return (Criteria) this;
        }

        public Criteria andPrefixContentNotEqualTo(String value) {
            addCriterion("prefix_content <>", value, "prefixContent");
            return (Criteria) this;
        }

        public Criteria andPrefixContentGreaterThan(String value) {
            addCriterion("prefix_content >", value, "prefixContent");
            return (Criteria) this;
        }

        public Criteria andPrefixContentGreaterThanOrEqualTo(String value) {
            addCriterion("prefix_content >=", value, "prefixContent");
            return (Criteria) this;
        }

        public Criteria andPrefixContentLessThan(String value) {
            addCriterion("prefix_content <", value, "prefixContent");
            return (Criteria) this;
        }

        public Criteria andPrefixContentLessThanOrEqualTo(String value) {
            addCriterion("prefix_content <=", value, "prefixContent");
            return (Criteria) this;
        }

        public Criteria andPrefixContentLike(String value) {
            addCriterion("prefix_content like", value, "prefixContent");
            return (Criteria) this;
        }

        public Criteria andPrefixContentNotLike(String value) {
            addCriterion("prefix_content not like", value, "prefixContent");
            return (Criteria) this;
        }

        public Criteria andPrefixContentIn(List<String> values) {
            addCriterion("prefix_content in", values, "prefixContent");
            return (Criteria) this;
        }

        public Criteria andPrefixContentNotIn(List<String> values) {
            addCriterion("prefix_content not in", values, "prefixContent");
            return (Criteria) this;
        }

        public Criteria andPrefixContentBetween(String value1, String value2) {
            addCriterion("prefix_content between", value1, value2, "prefixContent");
            return (Criteria) this;
        }

        public Criteria andPrefixContentNotBetween(String value1, String value2) {
            addCriterion("prefix_content not between", value1, value2, "prefixContent");
            return (Criteria) this;
        }

        public Criteria andPrefixPicIsNull() {
            addCriterion("prefix_pic is null");
            return (Criteria) this;
        }

        public Criteria andPrefixPicIsNotNull() {
            addCriterion("prefix_pic is not null");
            return (Criteria) this;
        }

        public Criteria andPrefixPicEqualTo(String value) {
            addCriterion("prefix_pic =", value, "prefixPic");
            return (Criteria) this;
        }

        public Criteria andPrefixPicNotEqualTo(String value) {
            addCriterion("prefix_pic <>", value, "prefixPic");
            return (Criteria) this;
        }

        public Criteria andPrefixPicGreaterThan(String value) {
            addCriterion("prefix_pic >", value, "prefixPic");
            return (Criteria) this;
        }

        public Criteria andPrefixPicGreaterThanOrEqualTo(String value) {
            addCriterion("prefix_pic >=", value, "prefixPic");
            return (Criteria) this;
        }

        public Criteria andPrefixPicLessThan(String value) {
            addCriterion("prefix_pic <", value, "prefixPic");
            return (Criteria) this;
        }

        public Criteria andPrefixPicLessThanOrEqualTo(String value) {
            addCriterion("prefix_pic <=", value, "prefixPic");
            return (Criteria) this;
        }

        public Criteria andPrefixPicLike(String value) {
            addCriterion("prefix_pic like", value, "prefixPic");
            return (Criteria) this;
        }

        public Criteria andPrefixPicNotLike(String value) {
            addCriterion("prefix_pic not like", value, "prefixPic");
            return (Criteria) this;
        }

        public Criteria andPrefixPicIn(List<String> values) {
            addCriterion("prefix_pic in", values, "prefixPic");
            return (Criteria) this;
        }

        public Criteria andPrefixPicNotIn(List<String> values) {
            addCriterion("prefix_pic not in", values, "prefixPic");
            return (Criteria) this;
        }

        public Criteria andPrefixPicBetween(String value1, String value2) {
            addCriterion("prefix_pic between", value1, value2, "prefixPic");
            return (Criteria) this;
        }

        public Criteria andPrefixPicNotBetween(String value1, String value2) {
            addCriterion("prefix_pic not between", value1, value2, "prefixPic");
            return (Criteria) this;
        }

        public Criteria andAbstractLengthIsNull() {
            addCriterion("abstract_length is null");
            return (Criteria) this;
        }

        public Criteria andAbstractLengthIsNotNull() {
            addCriterion("abstract_length is not null");
            return (Criteria) this;
        }

        public Criteria andAbstractLengthEqualTo(String value) {
            addCriterion("abstract_length =", value, "abstractLength");
            return (Criteria) this;
        }

        public Criteria andAbstractLengthNotEqualTo(String value) {
            addCriterion("abstract_length <>", value, "abstractLength");
            return (Criteria) this;
        }

        public Criteria andAbstractLengthGreaterThan(String value) {
            addCriterion("abstract_length >", value, "abstractLength");
            return (Criteria) this;
        }

        public Criteria andAbstractLengthGreaterThanOrEqualTo(String value) {
            addCriterion("abstract_length >=", value, "abstractLength");
            return (Criteria) this;
        }

        public Criteria andAbstractLengthLessThan(String value) {
            addCriterion("abstract_length <", value, "abstractLength");
            return (Criteria) this;
        }

        public Criteria andAbstractLengthLessThanOrEqualTo(String value) {
            addCriterion("abstract_length <=", value, "abstractLength");
            return (Criteria) this;
        }

        public Criteria andAbstractLengthLike(String value) {
            addCriterion("abstract_length like", value, "abstractLength");
            return (Criteria) this;
        }

        public Criteria andAbstractLengthNotLike(String value) {
            addCriterion("abstract_length not like", value, "abstractLength");
            return (Criteria) this;
        }

        public Criteria andAbstractLengthIn(List<String> values) {
            addCriterion("abstract_length in", values, "abstractLength");
            return (Criteria) this;
        }

        public Criteria andAbstractLengthNotIn(List<String> values) {
            addCriterion("abstract_length not in", values, "abstractLength");
            return (Criteria) this;
        }

        public Criteria andAbstractLengthBetween(String value1, String value2) {
            addCriterion("abstract_length between", value1, value2, "abstractLength");
            return (Criteria) this;
        }

        public Criteria andAbstractLengthNotBetween(String value1, String value2) {
            addCriterion("abstract_length not between", value1, value2, "abstractLength");
            return (Criteria) this;
        }

        public Criteria andAbstractLineNumberIsNull() {
            addCriterion("abstract_line_number is null");
            return (Criteria) this;
        }

        public Criteria andAbstractLineNumberIsNotNull() {
            addCriterion("abstract_line_number is not null");
            return (Criteria) this;
        }

        public Criteria andAbstractLineNumberEqualTo(Integer value) {
            addCriterion("abstract_line_number =", value, "abstractLineNumber");
            return (Criteria) this;
        }

        public Criteria andAbstractLineNumberNotEqualTo(Integer value) {
            addCriterion("abstract_line_number <>", value, "abstractLineNumber");
            return (Criteria) this;
        }

        public Criteria andAbstractLineNumberGreaterThan(Integer value) {
            addCriterion("abstract_line_number >", value, "abstractLineNumber");
            return (Criteria) this;
        }

        public Criteria andAbstractLineNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("abstract_line_number >=", value, "abstractLineNumber");
            return (Criteria) this;
        }

        public Criteria andAbstractLineNumberLessThan(Integer value) {
            addCriterion("abstract_line_number <", value, "abstractLineNumber");
            return (Criteria) this;
        }

        public Criteria andAbstractLineNumberLessThanOrEqualTo(Integer value) {
            addCriterion("abstract_line_number <=", value, "abstractLineNumber");
            return (Criteria) this;
        }

        public Criteria andAbstractLineNumberIn(List<Integer> values) {
            addCriterion("abstract_line_number in", values, "abstractLineNumber");
            return (Criteria) this;
        }

        public Criteria andAbstractLineNumberNotIn(List<Integer> values) {
            addCriterion("abstract_line_number not in", values, "abstractLineNumber");
            return (Criteria) this;
        }

        public Criteria andAbstractLineNumberBetween(Integer value1, Integer value2) {
            addCriterion("abstract_line_number between", value1, value2, "abstractLineNumber");
            return (Criteria) this;
        }

        public Criteria andAbstractLineNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("abstract_line_number not between", value1, value2, "abstractLineNumber");
            return (Criteria) this;
        }

        public Criteria andPicHeightIsNull() {
            addCriterion("pic_height is null");
            return (Criteria) this;
        }

        public Criteria andPicHeightIsNotNull() {
            addCriterion("pic_height is not null");
            return (Criteria) this;
        }

        public Criteria andPicHeightEqualTo(String value) {
            addCriterion("pic_height =", value, "picHeight");
            return (Criteria) this;
        }

        public Criteria andPicHeightNotEqualTo(String value) {
            addCriterion("pic_height <>", value, "picHeight");
            return (Criteria) this;
        }

        public Criteria andPicHeightGreaterThan(String value) {
            addCriterion("pic_height >", value, "picHeight");
            return (Criteria) this;
        }

        public Criteria andPicHeightGreaterThanOrEqualTo(String value) {
            addCriterion("pic_height >=", value, "picHeight");
            return (Criteria) this;
        }

        public Criteria andPicHeightLessThan(String value) {
            addCriterion("pic_height <", value, "picHeight");
            return (Criteria) this;
        }

        public Criteria andPicHeightLessThanOrEqualTo(String value) {
            addCriterion("pic_height <=", value, "picHeight");
            return (Criteria) this;
        }

        public Criteria andPicHeightLike(String value) {
            addCriterion("pic_height like", value, "picHeight");
            return (Criteria) this;
        }

        public Criteria andPicHeightNotLike(String value) {
            addCriterion("pic_height not like", value, "picHeight");
            return (Criteria) this;
        }

        public Criteria andPicHeightIn(List<String> values) {
            addCriterion("pic_height in", values, "picHeight");
            return (Criteria) this;
        }

        public Criteria andPicHeightNotIn(List<String> values) {
            addCriterion("pic_height not in", values, "picHeight");
            return (Criteria) this;
        }

        public Criteria andPicHeightBetween(String value1, String value2) {
            addCriterion("pic_height between", value1, value2, "picHeight");
            return (Criteria) this;
        }

        public Criteria andPicHeightNotBetween(String value1, String value2) {
            addCriterion("pic_height not between", value1, value2, "picHeight");
            return (Criteria) this;
        }

        public Criteria andPicWideIsNull() {
            addCriterion("pic_wide is null");
            return (Criteria) this;
        }

        public Criteria andPicWideIsNotNull() {
            addCriterion("pic_wide is not null");
            return (Criteria) this;
        }

        public Criteria andPicWideEqualTo(String value) {
            addCriterion("pic_wide =", value, "picWide");
            return (Criteria) this;
        }

        public Criteria andPicWideNotEqualTo(String value) {
            addCriterion("pic_wide <>", value, "picWide");
            return (Criteria) this;
        }

        public Criteria andPicWideGreaterThan(String value) {
            addCriterion("pic_wide >", value, "picWide");
            return (Criteria) this;
        }

        public Criteria andPicWideGreaterThanOrEqualTo(String value) {
            addCriterion("pic_wide >=", value, "picWide");
            return (Criteria) this;
        }

        public Criteria andPicWideLessThan(String value) {
            addCriterion("pic_wide <", value, "picWide");
            return (Criteria) this;
        }

        public Criteria andPicWideLessThanOrEqualTo(String value) {
            addCriterion("pic_wide <=", value, "picWide");
            return (Criteria) this;
        }

        public Criteria andPicWideLike(String value) {
            addCriterion("pic_wide like", value, "picWide");
            return (Criteria) this;
        }

        public Criteria andPicWideNotLike(String value) {
            addCriterion("pic_wide not like", value, "picWide");
            return (Criteria) this;
        }

        public Criteria andPicWideIn(List<String> values) {
            addCriterion("pic_wide in", values, "picWide");
            return (Criteria) this;
        }

        public Criteria andPicWideNotIn(List<String> values) {
            addCriterion("pic_wide not in", values, "picWide");
            return (Criteria) this;
        }

        public Criteria andPicWideBetween(String value1, String value2) {
            addCriterion("pic_wide between", value1, value2, "picWide");
            return (Criteria) this;
        }

        public Criteria andPicWideNotBetween(String value1, String value2) {
            addCriterion("pic_wide not between", value1, value2, "picWide");
            return (Criteria) this;
        }

        public Criteria andArticleAuthorIsNull() {
            addCriterion("article_author is null");
            return (Criteria) this;
        }

        public Criteria andArticleAuthorIsNotNull() {
            addCriterion("article_author is not null");
            return (Criteria) this;
        }

        public Criteria andArticleAuthorEqualTo(String value) {
            addCriterion("article_author =", value, "articleAuthor");
            return (Criteria) this;
        }

        public Criteria andArticleAuthorNotEqualTo(String value) {
            addCriterion("article_author <>", value, "articleAuthor");
            return (Criteria) this;
        }

        public Criteria andArticleAuthorGreaterThan(String value) {
            addCriterion("article_author >", value, "articleAuthor");
            return (Criteria) this;
        }

        public Criteria andArticleAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("article_author >=", value, "articleAuthor");
            return (Criteria) this;
        }

        public Criteria andArticleAuthorLessThan(String value) {
            addCriterion("article_author <", value, "articleAuthor");
            return (Criteria) this;
        }

        public Criteria andArticleAuthorLessThanOrEqualTo(String value) {
            addCriterion("article_author <=", value, "articleAuthor");
            return (Criteria) this;
        }

        public Criteria andArticleAuthorLike(String value) {
            addCriterion("article_author like", value, "articleAuthor");
            return (Criteria) this;
        }

        public Criteria andArticleAuthorNotLike(String value) {
            addCriterion("article_author not like", value, "articleAuthor");
            return (Criteria) this;
        }

        public Criteria andArticleAuthorIn(List<String> values) {
            addCriterion("article_author in", values, "articleAuthor");
            return (Criteria) this;
        }

        public Criteria andArticleAuthorNotIn(List<String> values) {
            addCriterion("article_author not in", values, "articleAuthor");
            return (Criteria) this;
        }

        public Criteria andArticleAuthorBetween(String value1, String value2) {
            addCriterion("article_author between", value1, value2, "articleAuthor");
            return (Criteria) this;
        }

        public Criteria andArticleAuthorNotBetween(String value1, String value2) {
            addCriterion("article_author not between", value1, value2, "articleAuthor");
            return (Criteria) this;
        }

        public Criteria andChildrenClomnsIsNull() {
            addCriterion("children_clomns is null");
            return (Criteria) this;
        }

        public Criteria andChildrenClomnsIsNotNull() {
            addCriterion("children_clomns is not null");
            return (Criteria) this;
        }

        public Criteria andChildrenClomnsEqualTo(Integer value) {
            addCriterion("children_clomns =", value, "childrenClomns");
            return (Criteria) this;
        }

        public Criteria andChildrenClomnsNotEqualTo(Integer value) {
            addCriterion("children_clomns <>", value, "childrenClomns");
            return (Criteria) this;
        }

        public Criteria andChildrenClomnsGreaterThan(Integer value) {
            addCriterion("children_clomns >", value, "childrenClomns");
            return (Criteria) this;
        }

        public Criteria andChildrenClomnsGreaterThanOrEqualTo(Integer value) {
            addCriterion("children_clomns >=", value, "childrenClomns");
            return (Criteria) this;
        }

        public Criteria andChildrenClomnsLessThan(Integer value) {
            addCriterion("children_clomns <", value, "childrenClomns");
            return (Criteria) this;
        }

        public Criteria andChildrenClomnsLessThanOrEqualTo(Integer value) {
            addCriterion("children_clomns <=", value, "childrenClomns");
            return (Criteria) this;
        }

        public Criteria andChildrenClomnsIn(List<Integer> values) {
            addCriterion("children_clomns in", values, "childrenClomns");
            return (Criteria) this;
        }

        public Criteria andChildrenClomnsNotIn(List<Integer> values) {
            addCriterion("children_clomns not in", values, "childrenClomns");
            return (Criteria) this;
        }

        public Criteria andChildrenClomnsBetween(Integer value1, Integer value2) {
            addCriterion("children_clomns between", value1, value2, "childrenClomns");
            return (Criteria) this;
        }

        public Criteria andChildrenClomnsNotBetween(Integer value1, Integer value2) {
            addCriterion("children_clomns not between", value1, value2, "childrenClomns");
            return (Criteria) this;
        }

        public Criteria andOriginalIsNull() {
            addCriterion("original is null");
            return (Criteria) this;
        }

        public Criteria andOriginalIsNotNull() {
            addCriterion("original is not null");
            return (Criteria) this;
        }

        public Criteria andOriginalEqualTo(Integer value) {
            addCriterion("original =", value, "original");
            return (Criteria) this;
        }

        public Criteria andOriginalNotEqualTo(Integer value) {
            addCriterion("original <>", value, "original");
            return (Criteria) this;
        }

        public Criteria andOriginalGreaterThan(Integer value) {
            addCriterion("original >", value, "original");
            return (Criteria) this;
        }

        public Criteria andOriginalGreaterThanOrEqualTo(Integer value) {
            addCriterion("original >=", value, "original");
            return (Criteria) this;
        }

        public Criteria andOriginalLessThan(Integer value) {
            addCriterion("original <", value, "original");
            return (Criteria) this;
        }

        public Criteria andOriginalLessThanOrEqualTo(Integer value) {
            addCriterion("original <=", value, "original");
            return (Criteria) this;
        }

        public Criteria andOriginalIn(List<Integer> values) {
            addCriterion("original in", values, "original");
            return (Criteria) this;
        }

        public Criteria andOriginalNotIn(List<Integer> values) {
            addCriterion("original not in", values, "original");
            return (Criteria) this;
        }

        public Criteria andOriginalBetween(Integer value1, Integer value2) {
            addCriterion("original between", value1, value2, "original");
            return (Criteria) this;
        }

        public Criteria andOriginalNotBetween(Integer value1, Integer value2) {
            addCriterion("original not between", value1, value2, "original");
            return (Criteria) this;
        }

        public Criteria andModelIsNull() {
            addCriterion("model is null");
            return (Criteria) this;
        }

        public Criteria andModelIsNotNull() {
            addCriterion("model is not null");
            return (Criteria) this;
        }

        public Criteria andModelEqualTo(String value) {
            addCriterion("model =", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotEqualTo(String value) {
            addCriterion("model <>", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelGreaterThan(String value) {
            addCriterion("model >", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelGreaterThanOrEqualTo(String value) {
            addCriterion("model >=", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLessThan(String value) {
            addCriterion("model <", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLessThanOrEqualTo(String value) {
            addCriterion("model <=", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLike(String value) {
            addCriterion("model like", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotLike(String value) {
            addCriterion("model not like", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelIn(List<String> values) {
            addCriterion("model in", values, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotIn(List<String> values) {
            addCriterion("model not in", values, "model");
            return (Criteria) this;
        }

        public Criteria andModelBetween(String value1, String value2) {
            addCriterion("model between", value1, value2, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotBetween(String value1, String value2) {
            addCriterion("model not between", value1, value2, "model");
            return (Criteria) this;
        }

        public Criteria andRotationTypeIsNull() {
            addCriterion("rotation_type is null");
            return (Criteria) this;
        }

        public Criteria andRotationTypeIsNotNull() {
            addCriterion("rotation_type is not null");
            return (Criteria) this;
        }

        public Criteria andRotationTypeEqualTo(String value) {
            addCriterion("rotation_type =", value, "rotationType");
            return (Criteria) this;
        }

        public Criteria andRotationTypeNotEqualTo(String value) {
            addCriterion("rotation_type <>", value, "rotationType");
            return (Criteria) this;
        }

        public Criteria andRotationTypeGreaterThan(String value) {
            addCriterion("rotation_type >", value, "rotationType");
            return (Criteria) this;
        }

        public Criteria andRotationTypeGreaterThanOrEqualTo(String value) {
            addCriterion("rotation_type >=", value, "rotationType");
            return (Criteria) this;
        }

        public Criteria andRotationTypeLessThan(String value) {
            addCriterion("rotation_type <", value, "rotationType");
            return (Criteria) this;
        }

        public Criteria andRotationTypeLessThanOrEqualTo(String value) {
            addCriterion("rotation_type <=", value, "rotationType");
            return (Criteria) this;
        }

        public Criteria andRotationTypeLike(String value) {
            addCriterion("rotation_type like", value, "rotationType");
            return (Criteria) this;
        }

        public Criteria andRotationTypeNotLike(String value) {
            addCriterion("rotation_type not like", value, "rotationType");
            return (Criteria) this;
        }

        public Criteria andRotationTypeIn(List<String> values) {
            addCriterion("rotation_type in", values, "rotationType");
            return (Criteria) this;
        }

        public Criteria andRotationTypeNotIn(List<String> values) {
            addCriterion("rotation_type not in", values, "rotationType");
            return (Criteria) this;
        }

        public Criteria andRotationTypeBetween(String value1, String value2) {
            addCriterion("rotation_type between", value1, value2, "rotationType");
            return (Criteria) this;
        }

        public Criteria andRotationTypeNotBetween(String value1, String value2) {
            addCriterion("rotation_type not between", value1, value2, "rotationType");
            return (Criteria) this;
        }

        public Criteria andKeywordIsNull() {
            addCriterion("keyword is null");
            return (Criteria) this;
        }

        public Criteria andKeywordIsNotNull() {
            addCriterion("keyword is not null");
            return (Criteria) this;
        }

        public Criteria andKeywordEqualTo(String value) {
            addCriterion("keyword =", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordNotEqualTo(String value) {
            addCriterion("keyword <>", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordGreaterThan(String value) {
            addCriterion("keyword >", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordGreaterThanOrEqualTo(String value) {
            addCriterion("keyword >=", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordLessThan(String value) {
            addCriterion("keyword <", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordLessThanOrEqualTo(String value) {
            addCriterion("keyword <=", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordLike(String value) {
            addCriterion("keyword like", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordNotLike(String value) {
            addCriterion("keyword not like", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordIn(List<String> values) {
            addCriterion("keyword in", values, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordNotIn(List<String> values) {
            addCriterion("keyword not in", values, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordBetween(String value1, String value2) {
            addCriterion("keyword between", value1, value2, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordNotBetween(String value1, String value2) {
            addCriterion("keyword not between", value1, value2, "keyword");
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