package com.rundatop.sys.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArticleInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ArticleInfoExample() {
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

        public Criteria andKeyWorddIsNull() {
            addCriterion("key_wordd is null");
            return (Criteria) this;
        }

        public Criteria andKeyWorddIsNotNull() {
            addCriterion("key_wordd is not null");
            return (Criteria) this;
        }

        public Criteria andKeyWorddEqualTo(String value) {
            addCriterion("key_wordd =", value, "keyWordd");
            return (Criteria) this;
        }

        public Criteria andKeyWorddNotEqualTo(String value) {
            addCriterion("key_wordd <>", value, "keyWordd");
            return (Criteria) this;
        }

        public Criteria andKeyWorddGreaterThan(String value) {
            addCriterion("key_wordd >", value, "keyWordd");
            return (Criteria) this;
        }

        public Criteria andKeyWorddGreaterThanOrEqualTo(String value) {
            addCriterion("key_wordd >=", value, "keyWordd");
            return (Criteria) this;
        }

        public Criteria andKeyWorddLessThan(String value) {
            addCriterion("key_wordd <", value, "keyWordd");
            return (Criteria) this;
        }

        public Criteria andKeyWorddLessThanOrEqualTo(String value) {
            addCriterion("key_wordd <=", value, "keyWordd");
            return (Criteria) this;
        }

        public Criteria andKeyWorddLike(String value) {
            addCriterion("key_wordd like", value, "keyWordd");
            return (Criteria) this;
        }

        public Criteria andKeyWorddNotLike(String value) {
            addCriterion("key_wordd not like", value, "keyWordd");
            return (Criteria) this;
        }

        public Criteria andKeyWorddIn(List<String> values) {
            addCriterion("key_wordd in", values, "keyWordd");
            return (Criteria) this;
        }

        public Criteria andKeyWorddNotIn(List<String> values) {
            addCriterion("key_wordd not in", values, "keyWordd");
            return (Criteria) this;
        }

        public Criteria andKeyWorddBetween(String value1, String value2) {
            addCriterion("key_wordd between", value1, value2, "keyWordd");
            return (Criteria) this;
        }

        public Criteria andKeyWorddNotBetween(String value1, String value2) {
            addCriterion("key_wordd not between", value1, value2, "keyWordd");
            return (Criteria) this;
        }

        public Criteria andArticleTitleIsNull() {
            addCriterion("article_title is null");
            return (Criteria) this;
        }

        public Criteria andArticleTitleIsNotNull() {
            addCriterion("article_title is not null");
            return (Criteria) this;
        }

        public Criteria andArticleTitleEqualTo(String value) {
            addCriterion("article_title =", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleNotEqualTo(String value) {
            addCriterion("article_title <>", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleGreaterThan(String value) {
            addCriterion("article_title >", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleGreaterThanOrEqualTo(String value) {
            addCriterion("article_title >=", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleLessThan(String value) {
            addCriterion("article_title <", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleLessThanOrEqualTo(String value) {
            addCriterion("article_title <=", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleLike(String value) {
            addCriterion("article_title like", value, "articleTitle");
            return (Criteria) this;
        }
        //内容查询
        public Criteria andArticleContentLike(String value) {
        	addCriterion("arcticle_content like", value, "arcticleContent");
        	return (Criteria) this;
        }

        public Criteria andArticleTitleNotLike(String value) {
            addCriterion("article_title not like", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleIn(List<String> values) {
            addCriterion("article_title in", values, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleNotIn(List<String> values) {
            addCriterion("article_title not in", values, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleBetween(String value1, String value2) {
            addCriterion("article_title between", value1, value2, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleNotBetween(String value1, String value2) {
            addCriterion("article_title not between", value1, value2, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andIsOriginalIsOrNull() {
            addCriterion(" (is_original = 1 or is_original is null)");
            return (Criteria) this;
        }
        
        public Criteria andIsOriginalIsNull() {
            addCriterion("is_original is null");
            return (Criteria) this;
        }

        public Criteria andIsOriginalIsNotNull() {
            addCriterion("is_original is not null");
            return (Criteria) this;
        }

        public Criteria andIsOriginalEqualTo(Integer value) {
            addCriterion("is_original =", value, "isOriginal");
            return (Criteria) this;
        }

        public Criteria andIsOriginalNotEqualTo(Integer value) {
            addCriterion("is_original <>", value, "isOriginal");
            return (Criteria) this;
        }

        public Criteria andIsOriginalGreaterThan(Integer value) {
            addCriterion("is_original >", value, "isOriginal");
            return (Criteria) this;
        }

        public Criteria andIsOriginalGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_original >=", value, "isOriginal");
            return (Criteria) this;
        }

        public Criteria andIsOriginalLessThan(Integer value) {
            addCriterion("is_original <", value, "isOriginal");
            return (Criteria) this;
        }

        public Criteria andIsOriginalLessThanOrEqualTo(Integer value) {
            addCriterion("is_original <=", value, "isOriginal");
            return (Criteria) this;
        }

        public Criteria andIsOriginalIn(List<Integer> values) {
            addCriterion("is_original in", values, "isOriginal");
            return (Criteria) this;
        }

        public Criteria andIsOriginalNotIn(List<Integer> values) {
            addCriterion("is_original not in", values, "isOriginal");
            return (Criteria) this;
        }

        public Criteria andIsOriginalBetween(Integer value1, Integer value2) {
            addCriterion("is_original between", value1, value2, "isOriginal");
            return (Criteria) this;
        }

        public Criteria andIsOriginalNotBetween(Integer value1, Integer value2) {
            addCriterion("is_original not between", value1, value2, "isOriginal");
            return (Criteria) this;
        }
        
        public Criteria andFeeTypeOrIsNull() {
            addCriterion(" (fee_type = 0 or fee_type is null)");
            return (Criteria) this;
        }

        public Criteria andFeeTypeIsNull() {
            addCriterion("fee_type is null");
            return (Criteria) this;
        }

        public Criteria andFeeTypeIsNotNull() {
            addCriterion("fee_type is not null");
            return (Criteria) this;
        }

        public Criteria andFeeTypeEqualTo(Integer value) {
            addCriterion("fee_type =", value, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeNotEqualTo(Integer value) {
            addCriterion("fee_type <>", value, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeGreaterThan(Integer value) {
            addCriterion("fee_type >", value, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("fee_type >=", value, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeLessThan(Integer value) {
            addCriterion("fee_type <", value, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeLessThanOrEqualTo(Integer value) {
            addCriterion("fee_type <=", value, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeIn(List<Integer> values) {
            addCriterion("fee_type in", values, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeNotIn(List<Integer> values) {
            addCriterion("fee_type not in", values, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeBetween(Integer value1, Integer value2) {
            addCriterion("fee_type between", value1, value2, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("fee_type not between", value1, value2, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeIsNull() {
            addCriterion("fee is null");
            return (Criteria) this;
        }

        public Criteria andFeeIsNotNull() {
            addCriterion("fee is not null");
            return (Criteria) this;
        }

        public Criteria andFeeEqualTo(Integer value) {
            addCriterion("fee =", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotEqualTo(Integer value) {
            addCriterion("fee <>", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeGreaterThan(Integer value) {
            addCriterion("fee >", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeGreaterThanOrEqualTo(Integer value) {
            addCriterion("fee >=", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeLessThan(Integer value) {
            addCriterion("fee <", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeLessThanOrEqualTo(Integer value) {
            addCriterion("fee <=", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeIn(List<Integer> values) {
            addCriterion("fee in", values, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotIn(List<Integer> values) {
            addCriterion("fee not in", values, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeBetween(Integer value1, Integer value2) {
            addCriterion("fee between", value1, value2, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotBetween(Integer value1, Integer value2) {
            addCriterion("fee not between", value1, value2, "fee");
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

        public Criteria andArticleTypeEqualTo(Integer value) {
            addCriterion("article_type =", value, "articleType");
            return (Criteria) this;
        }

        public Criteria andArticleTypeNotEqualTo(Integer value) {
            addCriterion("article_type <>", value, "articleType");
            return (Criteria) this;
        }

        public Criteria andArticleTypeGreaterThan(Integer value) {
            addCriterion("article_type >", value, "articleType");
            return (Criteria) this;
        }

        public Criteria andArticleTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("article_type >=", value, "articleType");
            return (Criteria) this;
        }

        public Criteria andArticleTypeLessThan(Integer value) {
            addCriterion("article_type <", value, "articleType");
            return (Criteria) this;
        }

        public Criteria andArticleTypeLessThanOrEqualTo(Integer value) {
            addCriterion("article_type <=", value, "articleType");
            return (Criteria) this;
        }

        public Criteria andArticleTypeIn(List<Integer> values) {
            addCriterion("article_type in", values, "articleType");
            return (Criteria) this;
        }

        public Criteria andArticleTypeNotIn(List<Integer> values) {
            addCriterion("article_type not in", values, "articleType");
            return (Criteria) this;
        }

        public Criteria andArticleTypeBetween(Integer value1, Integer value2) {
            addCriterion("article_type between", value1, value2, "articleType");
            return (Criteria) this;
        }

        public Criteria andArticleTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("article_type not between", value1, value2, "articleType");
            return (Criteria) this;
        }

        public Criteria andArticleSourceIsNull() {
            addCriterion("article_source is null");
            return (Criteria) this;
        }

        public Criteria andArticleSourceIsNotNull() {
            addCriterion("article_source is not null");
            return (Criteria) this;
        }

        public Criteria andArticleSourceEqualTo(String value) {
            addCriterion("article_source =", value, "articleSource");
            return (Criteria) this;
        }

        public Criteria andArticleSourceNotEqualTo(String value) {
            addCriterion("article_source <>", value, "articleSource");
            return (Criteria) this;
        }

        public Criteria andArticleSourceGreaterThan(String value) {
            addCriterion("article_source >", value, "articleSource");
            return (Criteria) this;
        }

        public Criteria andArticleSourceGreaterThanOrEqualTo(String value) {
            addCriterion("article_source >=", value, "articleSource");
            return (Criteria) this;
        }

        public Criteria andArticleSourceLessThan(String value) {
            addCriterion("article_source <", value, "articleSource");
            return (Criteria) this;
        }

        public Criteria andArticleSourceLessThanOrEqualTo(String value) {
            addCriterion("article_source <=", value, "articleSource");
            return (Criteria) this;
        }

        public Criteria andArticleSourceLike(String value) {
            addCriterion("article_source like", value, "articleSource");
            return (Criteria) this;
        }

        public Criteria andArticleSourceNotLike(String value) {
            addCriterion("article_source not like", value, "articleSource");
            return (Criteria) this;
        }

        public Criteria andArticleSourceIn(List<String> values) {
            addCriterion("article_source in", values, "articleSource");
            return (Criteria) this;
        }

        public Criteria andArticleSourceNotIn(List<String> values) {
            addCriterion("article_source not in", values, "articleSource");
            return (Criteria) this;
        }

        public Criteria andArticleSourceBetween(String value1, String value2) {
            addCriterion("article_source between", value1, value2, "articleSource");
            return (Criteria) this;
        }

        public Criteria andArticleSourceNotBetween(String value1, String value2) {
            addCriterion("article_source not between", value1, value2, "articleSource");
            return (Criteria) this;
        }

        public Criteria andArcticleSummaryIsNull() {
            addCriterion("arcticle_summary is null");
            return (Criteria) this;
        }

        public Criteria andArcticleSummaryIsNotNull() {
            addCriterion("arcticle_summary is not null");
            return (Criteria) this;
        }

        public Criteria andArcticleSummaryEqualTo(String value) {
            addCriterion("arcticle_summary =", value, "arcticleSummary");
            return (Criteria) this;
        }

        public Criteria andArcticleSummaryNotEqualTo(String value) {
            addCriterion("arcticle_summary <>", value, "arcticleSummary");
            return (Criteria) this;
        }

        public Criteria andArcticleSummaryGreaterThan(String value) {
            addCriterion("arcticle_summary >", value, "arcticleSummary");
            return (Criteria) this;
        }

        public Criteria andArcticleSummaryGreaterThanOrEqualTo(String value) {
            addCriterion("arcticle_summary >=", value, "arcticleSummary");
            return (Criteria) this;
        }

        public Criteria andArcticleSummaryLessThan(String value) {
            addCriterion("arcticle_summary <", value, "arcticleSummary");
            return (Criteria) this;
        }

        public Criteria andArcticleSummaryLessThanOrEqualTo(String value) {
            addCriterion("arcticle_summary <=", value, "arcticleSummary");
            return (Criteria) this;
        }

        public Criteria andArcticleSummaryLike(String value) {
            addCriterion("arcticle_summary like", value, "arcticleSummary");
            return (Criteria) this;
        }

        public Criteria andArcticleSummaryNotLike(String value) {
            addCriterion("arcticle_summary not like", value, "arcticleSummary");
            return (Criteria) this;
        }

        public Criteria andArcticleSummaryIn(List<String> values) {
            addCriterion("arcticle_summary in", values, "arcticleSummary");
            return (Criteria) this;
        }

        public Criteria andArcticleSummaryNotIn(List<String> values) {
            addCriterion("arcticle_summary not in", values, "arcticleSummary");
            return (Criteria) this;
        }

        public Criteria andArcticleSummaryBetween(String value1, String value2) {
            addCriterion("arcticle_summary between", value1, value2, "arcticleSummary");
            return (Criteria) this;
        }

        public Criteria andArcticleSummaryNotBetween(String value1, String value2) {
            addCriterion("arcticle_summary not between", value1, value2, "arcticleSummary");
            return (Criteria) this;
        }

        public Criteria andLikeCountIsNull() {
            addCriterion("like_count is null");
            return (Criteria) this;
        }

        public Criteria andLikeCountIsNotNull() {
            addCriterion("like_count is not null");
            return (Criteria) this;
        }

        public Criteria andLikeCountEqualTo(Integer value) {
            addCriterion("like_count =", value, "likeCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountNotEqualTo(Integer value) {
            addCriterion("like_count <>", value, "likeCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountGreaterThan(Integer value) {
            addCriterion("like_count >", value, "likeCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("like_count >=", value, "likeCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountLessThan(Integer value) {
            addCriterion("like_count <", value, "likeCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountLessThanOrEqualTo(Integer value) {
            addCriterion("like_count <=", value, "likeCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountIn(List<Integer> values) {
            addCriterion("like_count in", values, "likeCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountNotIn(List<Integer> values) {
            addCriterion("like_count not in", values, "likeCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountBetween(Integer value1, Integer value2) {
            addCriterion("like_count between", value1, value2, "likeCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountNotBetween(Integer value1, Integer value2) {
            addCriterion("like_count not between", value1, value2, "likeCount");
            return (Criteria) this;
        }

        public Criteria andScanCountIsNull() {
            addCriterion("scan_count is null");
            return (Criteria) this;
        }

        public Criteria andScanCountIsNotNull() {
            addCriterion("scan_count is not null");
            return (Criteria) this;
        }

        public Criteria andScanCountEqualTo(Integer value) {
            addCriterion("scan_count =", value, "scanCount");
            return (Criteria) this;
        }

        public Criteria andScanCountNotEqualTo(Integer value) {
            addCriterion("scan_count <>", value, "scanCount");
            return (Criteria) this;
        }

        public Criteria andScanCountGreaterThan(Integer value) {
            addCriterion("scan_count >", value, "scanCount");
            return (Criteria) this;
        }

        public Criteria andScanCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("scan_count >=", value, "scanCount");
            return (Criteria) this;
        }

        public Criteria andScanCountLessThan(Integer value) {
            addCriterion("scan_count <", value, "scanCount");
            return (Criteria) this;
        }

        public Criteria andScanCountLessThanOrEqualTo(Integer value) {
            addCriterion("scan_count <=", value, "scanCount");
            return (Criteria) this;
        }

        public Criteria andScanCountIn(List<Integer> values) {
            addCriterion("scan_count in", values, "scanCount");
            return (Criteria) this;
        }

        public Criteria andScanCountNotIn(List<Integer> values) {
            addCriterion("scan_count not in", values, "scanCount");
            return (Criteria) this;
        }

        public Criteria andScanCountBetween(Integer value1, Integer value2) {
            addCriterion("scan_count between", value1, value2, "scanCount");
            return (Criteria) this;
        }

        public Criteria andScanCountNotBetween(Integer value1, Integer value2) {
            addCriterion("scan_count not between", value1, value2, "scanCount");
            return (Criteria) this;
        }

        public Criteria andEntryDateIsNull() {
            addCriterion("entry_date is null");
            return (Criteria) this;
        }

        public Criteria andEntryDateIsNotNull() {
            addCriterion("entry_date is not null");
            return (Criteria) this;
        }

        public Criteria andEntryDateEqualTo(Date value) {
            addCriterion("entry_date =", value, "entryDate");
            return (Criteria) this;
        }

        public Criteria andEntryDateNotEqualTo(Date value) {
            addCriterion("entry_date <>", value, "entryDate");
            return (Criteria) this;
        }

        public Criteria andEntryDateGreaterThan(Date value) {
            addCriterion("entry_date >", value, "entryDate");
            return (Criteria) this;
        }

        public Criteria andEntryDateGreaterThanOrEqualTo(Date value) {
            addCriterion("entry_date >=", value, "entryDate");
            return (Criteria) this;
        }

        public Criteria andEntryDateLessThan(Date value) {
            addCriterion("entry_date <", value, "entryDate");
            return (Criteria) this;
        }

        public Criteria andEntryDateLessThanOrEqualTo(Date value) {
            addCriterion("entry_date <=", value, "entryDate");
            return (Criteria) this;
        }

        public Criteria andEntryDateIn(List<Date> values) {
            addCriterion("entry_date in", values, "entryDate");
            return (Criteria) this;
        }

        public Criteria andEntryDateNotIn(List<Date> values) {
            addCriterion("entry_date not in", values, "entryDate");
            return (Criteria) this;
        }

        public Criteria andEntryDateBetween(Date value1, Date value2) {
            addCriterion("entry_date between", value1, value2, "entryDate");
            return (Criteria) this;
        }

        public Criteria andEntryDateNotBetween(Date value1, Date value2) {
            addCriterion("entry_date not between", value1, value2, "entryDate");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIsNull() {
            addCriterion("order_time is null");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIsNotNull() {
            addCriterion("order_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTimeEqualTo(Date value) {
            addCriterion("order_time =", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotEqualTo(Date value) {
            addCriterion("order_time <>", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeGreaterThan(Date value) {
            addCriterion("order_time >", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("order_time >=", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeLessThan(Date value) {
            addCriterion("order_time <", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeLessThanOrEqualTo(Date value) {
            addCriterion("order_time <=", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIn(List<Date> values) {
            addCriterion("order_time in", values, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotIn(List<Date> values) {
            addCriterion("order_time not in", values, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeBetween(Date value1, Date value2) {
            addCriterion("order_time between", value1, value2, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotBetween(Date value1, Date value2) {
            addCriterion("order_time not between", value1, value2, "orderTime");
            return (Criteria) this;
        }

        public Criteria andIsTopIsNull() {
            addCriterion("is_top is null");
            return (Criteria) this;
        }

        public Criteria andIsTopIsNotNull() {
            addCriterion("is_top is not null");
            return (Criteria) this;
        }

        public Criteria andIsTopEqualTo(Integer value) {
            addCriterion("is_top =", value, "isTop");
            return (Criteria) this;
        }

        public Criteria andIsTopNotEqualTo(Integer value) {
            addCriterion("is_top <>", value, "isTop");
            return (Criteria) this;
        }

        public Criteria andIsTopGreaterThan(Integer value) {
            addCriterion("is_top >", value, "isTop");
            return (Criteria) this;
        }

        public Criteria andIsTopGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_top >=", value, "isTop");
            return (Criteria) this;
        }

        public Criteria andIsTopLessThan(Integer value) {
            addCriterion("is_top <", value, "isTop");
            return (Criteria) this;
        }

        public Criteria andIsTopLessThanOrEqualTo(Integer value) {
            addCriterion("is_top <=", value, "isTop");
            return (Criteria) this;
        }

        public Criteria andIsTopIn(List<Integer> values) {
            addCriterion("is_top in", values, "isTop");
            return (Criteria) this;
        }

        public Criteria andIsTopNotIn(List<Integer> values) {
            addCriterion("is_top not in", values, "isTop");
            return (Criteria) this;
        }

        public Criteria andIsTopBetween(Integer value1, Integer value2) {
            addCriterion("is_top between", value1, value2, "isTop");
            return (Criteria) this;
        }

        public Criteria andIsTopNotBetween(Integer value1, Integer value2) {
            addCriterion("is_top not between", value1, value2, "isTop");
            return (Criteria) this;
        }

        public Criteria andArticleTitle2IsNull() {
            addCriterion("article_title2 is null");
            return (Criteria) this;
        }

        public Criteria andArticleTitle2IsNotNull() {
            addCriterion("article_title2 is not null");
            return (Criteria) this;
        }

        public Criteria andArticleTitle2EqualTo(String value) {
            addCriterion("article_title2 =", value, "articleTitle2");
            return (Criteria) this;
        }

        public Criteria andArticleTitle2NotEqualTo(String value) {
            addCriterion("article_title2 <>", value, "articleTitle2");
            return (Criteria) this;
        }

        public Criteria andArticleTitle2GreaterThan(String value) {
            addCriterion("article_title2 >", value, "articleTitle2");
            return (Criteria) this;
        }

        public Criteria andArticleTitle2GreaterThanOrEqualTo(String value) {
            addCriterion("article_title2 >=", value, "articleTitle2");
            return (Criteria) this;
        }

        public Criteria andArticleTitle2LessThan(String value) {
            addCriterion("article_title2 <", value, "articleTitle2");
            return (Criteria) this;
        }

        public Criteria andArticleTitle2LessThanOrEqualTo(String value) {
            addCriterion("article_title2 <=", value, "articleTitle2");
            return (Criteria) this;
        }

        public Criteria andArticleTitle2Like(String value) {
            addCriterion("article_title2 like", value, "articleTitle2");
            return (Criteria) this;
        }

        public Criteria andArticleTitle2NotLike(String value) {
            addCriterion("article_title2 not like", value, "articleTitle2");
            return (Criteria) this;
        }

        public Criteria andArticleTitle2In(List<String> values) {
            addCriterion("article_title2 in", values, "articleTitle2");
            return (Criteria) this;
        }

        public Criteria andArticleTitle2NotIn(List<String> values) {
            addCriterion("article_title2 not in", values, "articleTitle2");
            return (Criteria) this;
        }

        public Criteria andArticleTitle2Between(String value1, String value2) {
            addCriterion("article_title2 between", value1, value2, "articleTitle2");
            return (Criteria) this;
        }

        public Criteria andArticleTitle2NotBetween(String value1, String value2) {
            addCriterion("article_title2 not between", value1, value2, "articleTitle2");
            return (Criteria) this;
        }

        public Criteria andTitleAllIsNull() {
            addCriterion("title_all is null");
            return (Criteria) this;
        }

        public Criteria andTitleAllIsNotNull() {
            addCriterion("title_all is not null");
            return (Criteria) this;
        }

        public Criteria andTitleAllEqualTo(String value) {
            addCriterion("title_all =", value, "titleAll");
            return (Criteria) this;
        }

        public Criteria andTitleAllNotEqualTo(String value) {
            addCriterion("title_all <>", value, "titleAll");
            return (Criteria) this;
        }

        public Criteria andTitleAllGreaterThan(String value) {
            addCriterion("title_all >", value, "titleAll");
            return (Criteria) this;
        }

        public Criteria andTitleAllGreaterThanOrEqualTo(String value) {
            addCriterion("title_all >=", value, "titleAll");
            return (Criteria) this;
        }

        public Criteria andTitleAllLessThan(String value) {
            addCriterion("title_all <", value, "titleAll");
            return (Criteria) this;
        }

        public Criteria andTitleAllLessThanOrEqualTo(String value) {
            addCriterion("title_all <=", value, "titleAll");
            return (Criteria) this;
        }

        public Criteria andTitleAllLike(String value) {
            addCriterion("title_all like", value, "titleAll");
            return (Criteria) this;
        }

        public Criteria andTitleAllNotLike(String value) {
            addCriterion("title_all not like", value, "titleAll");
            return (Criteria) this;
        }

        public Criteria andTitleAllIn(List<String> values) {
            addCriterion("title_all in", values, "titleAll");
            return (Criteria) this;
        }

        public Criteria andTitleAllNotIn(List<String> values) {
            addCriterion("title_all not in", values, "titleAll");
            return (Criteria) this;
        }

        public Criteria andTitleAllBetween(String value1, String value2) {
            addCriterion("title_all between", value1, value2, "titleAll");
            return (Criteria) this;
        }

        public Criteria andTitleAllNotBetween(String value1, String value2) {
            addCriterion("title_all not between", value1, value2, "titleAll");
            return (Criteria) this;
        }

        public Criteria andSubTitleIsNull() {
            addCriterion("sub_title is null");
            return (Criteria) this;
        }

        public Criteria andSubTitleIsNotNull() {
            addCriterion("sub_title is not null");
            return (Criteria) this;
        }

        public Criteria andSubTitleEqualTo(String value) {
            addCriterion("sub_title =", value, "subTitle");
            return (Criteria) this;
        }

        public Criteria andSubTitleNotEqualTo(String value) {
            addCriterion("sub_title <>", value, "subTitle");
            return (Criteria) this;
        }

        public Criteria andSubTitleGreaterThan(String value) {
            addCriterion("sub_title >", value, "subTitle");
            return (Criteria) this;
        }

        public Criteria andSubTitleGreaterThanOrEqualTo(String value) {
            addCriterion("sub_title >=", value, "subTitle");
            return (Criteria) this;
        }

        public Criteria andSubTitleLessThan(String value) {
            addCriterion("sub_title <", value, "subTitle");
            return (Criteria) this;
        }

        public Criteria andSubTitleLessThanOrEqualTo(String value) {
            addCriterion("sub_title <=", value, "subTitle");
            return (Criteria) this;
        }

        public Criteria andSubTitleLike(String value) {
            addCriterion("sub_title like", value, "subTitle");
            return (Criteria) this;
        }

        public Criteria andSubTitleNotLike(String value) {
            addCriterion("sub_title not like", value, "subTitle");
            return (Criteria) this;
        }

        public Criteria andSubTitleIn(List<String> values) {
            addCriterion("sub_title in", values, "subTitle");
            return (Criteria) this;
        }

        public Criteria andSubTitleNotIn(List<String> values) {
            addCriterion("sub_title not in", values, "subTitle");
            return (Criteria) this;
        }

        public Criteria andSubTitleBetween(String value1, String value2) {
            addCriterion("sub_title between", value1, value2, "subTitle");
            return (Criteria) this;
        }

        public Criteria andSubTitleNotBetween(String value1, String value2) {
            addCriterion("sub_title not between", value1, value2, "subTitle");
            return (Criteria) this;
        }

        public Criteria andOldTitleIsNull() {
            addCriterion("old_title is null");
            return (Criteria) this;
        }

        public Criteria andOldTitleIsNotNull() {
            addCriterion("old_title is not null");
            return (Criteria) this;
        }

        public Criteria andOldTitleEqualTo(String value) {
            addCriterion("old_title =", value, "oldTitle");
            return (Criteria) this;
        }

        public Criteria andOldTitleNotEqualTo(String value) {
            addCriterion("old_title <>", value, "oldTitle");
            return (Criteria) this;
        }

        public Criteria andOldTitleGreaterThan(String value) {
            addCriterion("old_title >", value, "oldTitle");
            return (Criteria) this;
        }

        public Criteria andOldTitleGreaterThanOrEqualTo(String value) {
            addCriterion("old_title >=", value, "oldTitle");
            return (Criteria) this;
        }

        public Criteria andOldTitleLessThan(String value) {
            addCriterion("old_title <", value, "oldTitle");
            return (Criteria) this;
        }

        public Criteria andOldTitleLessThanOrEqualTo(String value) {
            addCriterion("old_title <=", value, "oldTitle");
            return (Criteria) this;
        }

        public Criteria andOldTitleLike(String value) {
            addCriterion("old_title like", value, "oldTitle");
            return (Criteria) this;
        }

        public Criteria andOldTitleNotLike(String value) {
            addCriterion("old_title not like", value, "oldTitle");
            return (Criteria) this;
        }

        public Criteria andOldTitleIn(List<String> values) {
            addCriterion("old_title in", values, "oldTitle");
            return (Criteria) this;
        }

        public Criteria andOldTitleNotIn(List<String> values) {
            addCriterion("old_title not in", values, "oldTitle");
            return (Criteria) this;
        }

        public Criteria andOldTitleBetween(String value1, String value2) {
            addCriterion("old_title between", value1, value2, "oldTitle");
            return (Criteria) this;
        }

        public Criteria andOldTitleNotBetween(String value1, String value2) {
            addCriterion("old_title not between", value1, value2, "oldTitle");
            return (Criteria) this;
        }

        public Criteria andArctlcleAuthorIsNull() {
            addCriterion("arctlcle_author is null");
            return (Criteria) this;
        }

        public Criteria andArctlcleAuthorIsNotNull() {
            addCriterion("arctlcle_author is not null");
            return (Criteria) this;
        }

        public Criteria andArctlcleAuthorEqualTo(String value) {
            addCriterion("arctlcle_author =", value, "arctlcleAuthor");
            return (Criteria) this;
        }

        public Criteria andArctlcleAuthorNotEqualTo(String value) {
            addCriterion("arctlcle_author <>", value, "arctlcleAuthor");
            return (Criteria) this;
        }

        public Criteria andArctlcleAuthorGreaterThan(String value) {
            addCriterion("arctlcle_author >", value, "arctlcleAuthor");
            return (Criteria) this;
        }

        public Criteria andArctlcleAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("arctlcle_author >=", value, "arctlcleAuthor");
            return (Criteria) this;
        }

        public Criteria andArctlcleAuthorLessThan(String value) {
            addCriterion("arctlcle_author <", value, "arctlcleAuthor");
            return (Criteria) this;
        }

        public Criteria andArctlcleAuthorLessThanOrEqualTo(String value) {
            addCriterion("arctlcle_author <=", value, "arctlcleAuthor");
            return (Criteria) this;
        }

        public Criteria andArctlcleAuthorLike(String value) {
            addCriterion("arctlcle_author like", value, "arctlcleAuthor");
            return (Criteria) this;
        }

        public Criteria andArctlcleAuthorNotLike(String value) {
            addCriterion("arctlcle_author not like", value, "arctlcleAuthor");
            return (Criteria) this;
        }

        public Criteria andArctlcleAuthorIn(List<String> values) {
            addCriterion("arctlcle_author in", values, "arctlcleAuthor");
            return (Criteria) this;
        }

        public Criteria andArctlcleAuthorNotIn(List<String> values) {
            addCriterion("arctlcle_author not in", values, "arctlcleAuthor");
            return (Criteria) this;
        }

        public Criteria andArctlcleAuthorBetween(String value1, String value2) {
            addCriterion("arctlcle_author between", value1, value2, "arctlcleAuthor");
            return (Criteria) this;
        }

        public Criteria andArctlcleAuthorNotBetween(String value1, String value2) {
            addCriterion("arctlcle_author not between", value1, value2, "arctlcleAuthor");
            return (Criteria) this;
        }

        public Criteria andAuthorIdIsNull() {
            addCriterion("author_id is null");
            return (Criteria) this;
        }

        public Criteria andAuthorIdIsNotNull() {
            addCriterion("author_id is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorIdEqualTo(String value) {
            addCriterion("author_id =", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdNotEqualTo(String value) {
            addCriterion("author_id <>", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdGreaterThan(String value) {
            addCriterion("author_id >", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdGreaterThanOrEqualTo(String value) {
            addCriterion("author_id >=", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdLessThan(String value) {
            addCriterion("author_id <", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdLessThanOrEqualTo(String value) {
            addCriterion("author_id <=", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdLike(String value) {
            addCriterion("author_id like", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdNotLike(String value) {
            addCriterion("author_id not like", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdIn(List<String> values) {
            addCriterion("author_id in", values, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdNotIn(List<String> values) {
            addCriterion("author_id not in", values, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdBetween(String value1, String value2) {
            addCriterion("author_id between", value1, value2, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdNotBetween(String value1, String value2) {
            addCriterion("author_id not between", value1, value2, "authorId");
            return (Criteria) this;
        }

        public Criteria andPic1IsNull() {
            addCriterion("pic1 is null");
            return (Criteria) this;
        }

        public Criteria andPic1IsNotNull() {
            addCriterion("pic1 is not null");
            return (Criteria) this;
        }

        public Criteria andPic1EqualTo(String value) {
            addCriterion("pic1 =", value, "pic1");
            return (Criteria) this;
        }

        public Criteria andPic1NotEqualTo(String value) {
            addCriterion("pic1 <>", value, "pic1");
            return (Criteria) this;
        }

        public Criteria andPic1GreaterThan(String value) {
            addCriterion("pic1 >", value, "pic1");
            return (Criteria) this;
        }

        public Criteria andPic1GreaterThanOrEqualTo(String value) {
            addCriterion("pic1 >=", value, "pic1");
            return (Criteria) this;
        }

        public Criteria andPic1LessThan(String value) {
            addCriterion("pic1 <", value, "pic1");
            return (Criteria) this;
        }

        public Criteria andPic1LessThanOrEqualTo(String value) {
            addCriterion("pic1 <=", value, "pic1");
            return (Criteria) this;
        }

        public Criteria andPic1Like(String value) {
            addCriterion("pic1 like", value, "pic1");
            return (Criteria) this;
        }

        public Criteria andPic1NotLike(String value) {
            addCriterion("pic1 not like", value, "pic1");
            return (Criteria) this;
        }

        public Criteria andPic1In(List<String> values) {
            addCriterion("pic1 in", values, "pic1");
            return (Criteria) this;
        }

        public Criteria andPic1NotIn(List<String> values) {
            addCriterion("pic1 not in", values, "pic1");
            return (Criteria) this;
        }

        public Criteria andPic1Between(String value1, String value2) {
            addCriterion("pic1 between", value1, value2, "pic1");
            return (Criteria) this;
        }

        public Criteria andPic1NotBetween(String value1, String value2) {
            addCriterion("pic1 not between", value1, value2, "pic1");
            return (Criteria) this;
        }

        public Criteria andPic2IsNull() {
            addCriterion("pic2 is null");
            return (Criteria) this;
        }

        public Criteria andPic2IsNotNull() {
            addCriterion("pic2 is not null");
            return (Criteria) this;
        }

        public Criteria andPic2EqualTo(String value) {
            addCriterion("pic2 =", value, "pic2");
            return (Criteria) this;
        }

        public Criteria andPic2NotEqualTo(String value) {
            addCriterion("pic2 <>", value, "pic2");
            return (Criteria) this;
        }

        public Criteria andPic2GreaterThan(String value) {
            addCriterion("pic2 >", value, "pic2");
            return (Criteria) this;
        }

        public Criteria andPic2GreaterThanOrEqualTo(String value) {
            addCriterion("pic2 >=", value, "pic2");
            return (Criteria) this;
        }

        public Criteria andPic2LessThan(String value) {
            addCriterion("pic2 <", value, "pic2");
            return (Criteria) this;
        }

        public Criteria andPic2LessThanOrEqualTo(String value) {
            addCriterion("pic2 <=", value, "pic2");
            return (Criteria) this;
        }

        public Criteria andPic2Like(String value) {
            addCriterion("pic2 like", value, "pic2");
            return (Criteria) this;
        }

        public Criteria andPic2NotLike(String value) {
            addCriterion("pic2 not like", value, "pic2");
            return (Criteria) this;
        }

        public Criteria andPic2In(List<String> values) {
            addCriterion("pic2 in", values, "pic2");
            return (Criteria) this;
        }

        public Criteria andPic2NotIn(List<String> values) {
            addCriterion("pic2 not in", values, "pic2");
            return (Criteria) this;
        }

        public Criteria andPic2Between(String value1, String value2) {
            addCriterion("pic2 between", value1, value2, "pic2");
            return (Criteria) this;
        }

        public Criteria andPic2NotBetween(String value1, String value2) {
            addCriterion("pic2 not between", value1, value2, "pic2");
            return (Criteria) this;
        }

        public Criteria andArcticleStatusIsNull() {
            addCriterion("arcticle_status is null");
            return (Criteria) this;
        }

        public Criteria andArcticleStatusIsNotNull() {
            addCriterion("arcticle_status is not null");
            return (Criteria) this;
        }

        public Criteria andArcticleStatusEqualTo(Integer value) {
            addCriterion("arcticle_status =", value, "arcticleStatus");
            return (Criteria) this;
        }

        public Criteria andArcticleStatusNotEqualTo(Integer value) {
            addCriterion("arcticle_status <>", value, "arcticleStatus");
            return (Criteria) this;
        }

        public Criteria andArcticleStatusGreaterThan(Integer value) {
            addCriterion("arcticle_status >", value, "arcticleStatus");
            return (Criteria) this;
        }

        public Criteria andArcticleStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("arcticle_status >=", value, "arcticleStatus");
            return (Criteria) this;
        }

        public Criteria andArcticleStatusLessThan(Integer value) {
            addCriterion("arcticle_status <", value, "arcticleStatus");
            return (Criteria) this;
        }

        public Criteria andArcticleStatusLessThanOrEqualTo(Integer value) {
            addCriterion("arcticle_status <=", value, "arcticleStatus");
            return (Criteria) this;
        }

        public Criteria andArcticleStatusIn(List<Integer> values) {
            addCriterion("arcticle_status in", values, "arcticleStatus");
            return (Criteria) this;
        }

        public Criteria andArcticleStatusNotIn(List<Integer> values) {
            addCriterion("arcticle_status not in", values, "arcticleStatus");
            return (Criteria) this;
        }

        public Criteria andArcticleStatusBetween(Integer value1, Integer value2) {
            addCriterion("arcticle_status between", value1, value2, "arcticleStatus");
            return (Criteria) this;
        }

        public Criteria andArcticleStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("arcticle_status not between", value1, value2, "arcticleStatus");
            return (Criteria) this;
        }

        public Criteria andSourceIdIsNull() {
            addCriterion("source_id is null");
            return (Criteria) this;
        }

        public Criteria andSourceIdIsNotNull() {
            addCriterion("source_id is not null");
            return (Criteria) this;
        }

        public Criteria andSourceIdEqualTo(String value) {
            addCriterion("source_id =", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdNotEqualTo(String value) {
            addCriterion("source_id <>", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdGreaterThan(String value) {
            addCriterion("source_id >", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdGreaterThanOrEqualTo(String value) {
            addCriterion("source_id >=", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdLessThan(String value) {
            addCriterion("source_id <", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdLessThanOrEqualTo(String value) {
            addCriterion("source_id <=", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdLike(String value) {
            addCriterion("source_id like", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdNotLike(String value) {
            addCriterion("source_id not like", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdIn(List<String> values) {
            addCriterion("source_id in", values, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdNotIn(List<String> values) {
            addCriterion("source_id not in", values, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdBetween(String value1, String value2) {
            addCriterion("source_id between", value1, value2, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdNotBetween(String value1, String value2) {
            addCriterion("source_id not between", value1, value2, "sourceId");
            return (Criteria) this;
        }

        public Criteria andIsPerfectIsNull() {
            addCriterion("is_perfect is null");
            return (Criteria) this;
        }

        public Criteria andIsPerfectIsNotNull() {
            addCriterion("is_perfect is not null");
            return (Criteria) this;
        }

        public Criteria andIsPerfectEqualTo(Integer value) {
            addCriterion("is_perfect =", value, "isPerfect");
            return (Criteria) this;
        }

        public Criteria andIsPerfectNotEqualTo(Integer value) {
            addCriterion("is_perfect <>", value, "isPerfect");
            return (Criteria) this;
        }

        public Criteria andIsPerfectGreaterThan(Integer value) {
            addCriterion("is_perfect >", value, "isPerfect");
            return (Criteria) this;
        }

        public Criteria andIsPerfectGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_perfect >=", value, "isPerfect");
            return (Criteria) this;
        }

        public Criteria andIsPerfectLessThan(Integer value) {
            addCriterion("is_perfect <", value, "isPerfect");
            return (Criteria) this;
        }

        public Criteria andIsPerfectLessThanOrEqualTo(Integer value) {
            addCriterion("is_perfect <=", value, "isPerfect");
            return (Criteria) this;
        }

        public Criteria andIsPerfectIn(List<Integer> values) {
            addCriterion("is_perfect in", values, "isPerfect");
            return (Criteria) this;
        }

        public Criteria andIsPerfectNotIn(List<Integer> values) {
            addCriterion("is_perfect not in", values, "isPerfect");
            return (Criteria) this;
        }

        public Criteria andIsPerfectBetween(Integer value1, Integer value2) {
            addCriterion("is_perfect between", value1, value2, "isPerfect");
            return (Criteria) this;
        }

        public Criteria andIsPerfectNotBetween(Integer value1, Integer value2) {
            addCriterion("is_perfect not between", value1, value2, "isPerfect");
            return (Criteria) this;
        }

        public Criteria andCommentTypeIsNull() {
            addCriterion("comment_type is null");
            return (Criteria) this;
        }

        public Criteria andCommentTypeIsNotNull() {
            addCriterion("comment_type is not null");
            return (Criteria) this;
        }

        public Criteria andCommentTypeEqualTo(Integer value) {
            addCriterion("comment_type =", value, "commentType");
            return (Criteria) this;
        }

        public Criteria andCommentTypeNotEqualTo(Integer value) {
            addCriterion("comment_type <>", value, "commentType");
            return (Criteria) this;
        }

        public Criteria andCommentTypeGreaterThan(Integer value) {
            addCriterion("comment_type >", value, "commentType");
            return (Criteria) this;
        }

        public Criteria andCommentTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("comment_type >=", value, "commentType");
            return (Criteria) this;
        }

        public Criteria andCommentTypeLessThan(Integer value) {
            addCriterion("comment_type <", value, "commentType");
            return (Criteria) this;
        }

        public Criteria andCommentTypeLessThanOrEqualTo(Integer value) {
            addCriterion("comment_type <=", value, "commentType");
            return (Criteria) this;
        }

        public Criteria andCommentTypeIn(List<Integer> values) {
            addCriterion("comment_type in", values, "commentType");
            return (Criteria) this;
        }

        public Criteria andCommentTypeNotIn(List<Integer> values) {
            addCriterion("comment_type not in", values, "commentType");
            return (Criteria) this;
        }

        public Criteria andCommentTypeBetween(Integer value1, Integer value2) {
            addCriterion("comment_type between", value1, value2, "commentType");
            return (Criteria) this;
        }

        public Criteria andCommentTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("comment_type not between", value1, value2, "commentType");
            return (Criteria) this;
        }

        public Criteria andSurveyIdIsNull() {
            addCriterion("survey_id is null");
            return (Criteria) this;
        }

        public Criteria andSurveyIdIsNotNull() {
            addCriterion("survey_id is not null");
            return (Criteria) this;
        }

        public Criteria andSurveyIdEqualTo(String value) {
            addCriterion("survey_id =", value, "surveyId");
            return (Criteria) this;
        }

        public Criteria andSurveyIdNotEqualTo(String value) {
            addCriterion("survey_id <>", value, "surveyId");
            return (Criteria) this;
        }

        public Criteria andSurveyIdGreaterThan(String value) {
            addCriterion("survey_id >", value, "surveyId");
            return (Criteria) this;
        }

        public Criteria andSurveyIdGreaterThanOrEqualTo(String value) {
            addCriterion("survey_id >=", value, "surveyId");
            return (Criteria) this;
        }

        public Criteria andSurveyIdLessThan(String value) {
            addCriterion("survey_id <", value, "surveyId");
            return (Criteria) this;
        }

        public Criteria andSurveyIdLessThanOrEqualTo(String value) {
            addCriterion("survey_id <=", value, "surveyId");
            return (Criteria) this;
        }

        public Criteria andSurveyIdLike(String value) {
            addCriterion("survey_id like", value, "surveyId");
            return (Criteria) this;
        }

        public Criteria andSurveyIdNotLike(String value) {
            addCriterion("survey_id not like", value, "surveyId");
            return (Criteria) this;
        }

        public Criteria andSurveyIdIn(List<String> values) {
            addCriterion("survey_id in", values, "surveyId");
            return (Criteria) this;
        }

        public Criteria andSurveyIdNotIn(List<String> values) {
            addCriterion("survey_id not in", values, "surveyId");
            return (Criteria) this;
        }

        public Criteria andSurveyIdBetween(String value1, String value2) {
            addCriterion("survey_id between", value1, value2, "surveyId");
            return (Criteria) this;
        }

        public Criteria andSurveyIdNotBetween(String value1, String value2) {
            addCriterion("survey_id not between", value1, value2, "surveyId");
            return (Criteria) this;
        }

        public Criteria andHtmlUrlIsNull() {
            addCriterion("html_url is null");
            return (Criteria) this;
        }

        public Criteria andHtmlUrlIsNotNull() {
            addCriterion("html_url is not null");
            return (Criteria) this;
        }

        public Criteria andHtmlUrlEqualTo(String value) {
            addCriterion("html_url =", value, "htmlUrl");
            return (Criteria) this;
        }

        public Criteria andHtmlUrlNotEqualTo(String value) {
            addCriterion("html_url <>", value, "htmlUrl");
            return (Criteria) this;
        }

        public Criteria andHtmlUrlGreaterThan(String value) {
            addCriterion("html_url >", value, "htmlUrl");
            return (Criteria) this;
        }

        public Criteria andHtmlUrlGreaterThanOrEqualTo(String value) {
            addCriterion("html_url >=", value, "htmlUrl");
            return (Criteria) this;
        }

        public Criteria andHtmlUrlLessThan(String value) {
            addCriterion("html_url <", value, "htmlUrl");
            return (Criteria) this;
        }

        public Criteria andHtmlUrlLessThanOrEqualTo(String value) {
            addCriterion("html_url <=", value, "htmlUrl");
            return (Criteria) this;
        }

        public Criteria andHtmlUrlLike(String value) {
            addCriterion("html_url like", value, "htmlUrl");
            return (Criteria) this;
        }

        public Criteria andHtmlUrlNotLike(String value) {
            addCriterion("html_url not like", value, "htmlUrl");
            return (Criteria) this;
        }

        public Criteria andHtmlUrlIn(List<String> values) {
            addCriterion("html_url in", values, "htmlUrl");
            return (Criteria) this;
        }

        public Criteria andHtmlUrlNotIn(List<String> values) {
            addCriterion("html_url not in", values, "htmlUrl");
            return (Criteria) this;
        }

        public Criteria andHtmlUrlBetween(String value1, String value2) {
            addCriterion("html_url between", value1, value2, "htmlUrl");
            return (Criteria) this;
        }

        public Criteria andHtmlUrlNotBetween(String value1, String value2) {
            addCriterion("html_url not between", value1, value2, "htmlUrl");
            return (Criteria) this;
        }

        public Criteria andFileIsNull() {
            addCriterion("file is null");
            return (Criteria) this;
        }

        public Criteria andFileIsNotNull() {
            addCriterion("file is not null");
            return (Criteria) this;
        }

        public Criteria andFileEqualTo(String value) {
            addCriterion("file =", value, "file");
            return (Criteria) this;
        }

        public Criteria andFileNotEqualTo(String value) {
            addCriterion("file <>", value, "file");
            return (Criteria) this;
        }

        public Criteria andFileGreaterThan(String value) {
            addCriterion("file >", value, "file");
            return (Criteria) this;
        }

        public Criteria andFileGreaterThanOrEqualTo(String value) {
            addCriterion("file >=", value, "file");
            return (Criteria) this;
        }

        public Criteria andFileLessThan(String value) {
            addCriterion("file <", value, "file");
            return (Criteria) this;
        }

        public Criteria andFileLessThanOrEqualTo(String value) {
            addCriterion("file <=", value, "file");
            return (Criteria) this;
        }

        public Criteria andFileLike(String value) {
            addCriterion("file like", value, "file");
            return (Criteria) this;
        }

        public Criteria andFileNotLike(String value) {
            addCriterion("file not like", value, "file");
            return (Criteria) this;
        }

        public Criteria andFileIn(List<String> values) {
            addCriterion("file in", values, "file");
            return (Criteria) this;
        }

        public Criteria andFileNotIn(List<String> values) {
            addCriterion("file not in", values, "file");
            return (Criteria) this;
        }

        public Criteria andFileBetween(String value1, String value2) {
            addCriterion("file between", value1, value2, "file");
            return (Criteria) this;
        }

        public Criteria andFileNotBetween(String value1, String value2) {
            addCriterion("file not between", value1, value2, "file");
            return (Criteria) this;
        }

        public Criteria andAuthorNameIsNull() {
            addCriterion("author_name is null");
            return (Criteria) this;
        }

        public Criteria andAuthorNameIsNotNull() {
            addCriterion("author_name is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorNameEqualTo(String value) {
            addCriterion("author_name =", value, "authorName");
            return (Criteria) this;
        }

        public Criteria andAuthorNameNotEqualTo(String value) {
            addCriterion("author_name <>", value, "authorName");
            return (Criteria) this;
        }

        public Criteria andAuthorNameGreaterThan(String value) {
            addCriterion("author_name >", value, "authorName");
            return (Criteria) this;
        }

        public Criteria andAuthorNameGreaterThanOrEqualTo(String value) {
            addCriterion("author_name >=", value, "authorName");
            return (Criteria) this;
        }

        public Criteria andAuthorNameLessThan(String value) {
            addCriterion("author_name <", value, "authorName");
            return (Criteria) this;
        }

        public Criteria andAuthorNameLessThanOrEqualTo(String value) {
            addCriterion("author_name <=", value, "authorName");
            return (Criteria) this;
        }

        public Criteria andAuthorNameLike(String value) {
            addCriterion("author_name like", value, "authorName");
            return (Criteria) this;
        }

        public Criteria andAuthorNameNotLike(String value) {
            addCriterion("author_name not like", value, "authorName");
            return (Criteria) this;
        }

        public Criteria andAuthorNameIn(List<String> values) {
            addCriterion("author_name in", values, "authorName");
            return (Criteria) this;
        }

        public Criteria andAuthorNameNotIn(List<String> values) {
            addCriterion("author_name not in", values, "authorName");
            return (Criteria) this;
        }

        public Criteria andAuthorNameBetween(String value1, String value2) {
            addCriterion("author_name between", value1, value2, "authorName");
            return (Criteria) this;
        }

        public Criteria andAuthorNameNotBetween(String value1, String value2) {
            addCriterion("author_name not between", value1, value2, "authorName");
            return (Criteria) this;
        }

        public Criteria andContentSourceIsNull() {
            addCriterion("content_source is null");
            return (Criteria) this;
        }

        public Criteria andContentSourceIsNotNull() {
            addCriterion("content_source is not null");
            return (Criteria) this;
        }

        public Criteria andContentSourceEqualTo(String value) {
            addCriterion("content_source =", value, "contentSource");
            return (Criteria) this;
        }

        public Criteria andContentSourceNotEqualTo(String value) {
            addCriterion("content_source <>", value, "contentSource");
            return (Criteria) this;
        }

        public Criteria andContentSourceGreaterThan(String value) {
            addCriterion("content_source >", value, "contentSource");
            return (Criteria) this;
        }

        public Criteria andContentSourceGreaterThanOrEqualTo(String value) {
            addCriterion("content_source >=", value, "contentSource");
            return (Criteria) this;
        }

        public Criteria andContentSourceLessThan(String value) {
            addCriterion("content_source <", value, "contentSource");
            return (Criteria) this;
        }

        public Criteria andContentSourceLessThanOrEqualTo(String value) {
            addCriterion("content_source <=", value, "contentSource");
            return (Criteria) this;
        }

        public Criteria andContentSourceLike(String value) {
            addCriterion("content_source like", value, "contentSource");
            return (Criteria) this;
        }

        public Criteria andContentSourceNotLike(String value) {
            addCriterion("content_source not like", value, "contentSource");
            return (Criteria) this;
        }

        public Criteria andContentSourceIn(List<String> values) {
            addCriterion("content_source in", values, "contentSource");
            return (Criteria) this;
        }

        public Criteria andContentSourceNotIn(List<String> values) {
            addCriterion("content_source not in", values, "contentSource");
            return (Criteria) this;
        }

        public Criteria andContentSourceBetween(String value1, String value2) {
            addCriterion("content_source between", value1, value2, "contentSource");
            return (Criteria) this;
        }

        public Criteria andContentSourceNotBetween(String value1, String value2) {
            addCriterion("content_source not between", value1, value2, "contentSource");
            return (Criteria) this;
        }

        public Criteria andFree4IsNull() {
            addCriterion("free4 is null");
            return (Criteria) this;
        }

        public Criteria andFree4IsNotNull() {
            addCriterion("free4 is not null");
            return (Criteria) this;
        }

        public Criteria andFree4EqualTo(String value) {
            addCriterion("free4 =", value, "free4");
            return (Criteria) this;
        }

        public Criteria andFree4NotEqualTo(String value) {
            addCriterion("free4 <>", value, "free4");
            return (Criteria) this;
        }

        public Criteria andFree4GreaterThan(String value) {
            addCriterion("free4 >", value, "free4");
            return (Criteria) this;
        }

        public Criteria andFree4GreaterThanOrEqualTo(String value) {
            addCriterion("free4 >=", value, "free4");
            return (Criteria) this;
        }

        public Criteria andFree4LessThan(String value) {
            addCriterion("free4 <", value, "free4");
            return (Criteria) this;
        }

        public Criteria andFree4LessThanOrEqualTo(String value) {
            addCriterion("free4 <=", value, "free4");
            return (Criteria) this;
        }

        public Criteria andFree4Like(String value) {
            addCriterion("free4 like", value, "free4");
            return (Criteria) this;
        }

        public Criteria andFree4NotLike(String value) {
            addCriterion("free4 not like", value, "free4");
            return (Criteria) this;
        }

        public Criteria andFree4In(List<String> values) {
            addCriterion("free4 in", values, "free4");
            return (Criteria) this;
        }

        public Criteria andFree4NotIn(List<String> values) {
            addCriterion("free4 not in", values, "free4");
            return (Criteria) this;
        }

        public Criteria andFree4Between(String value1, String value2) {
            addCriterion("free4 between", value1, value2, "free4");
            return (Criteria) this;
        }

        public Criteria andFree4NotBetween(String value1, String value2) {
            addCriterion("free4 not between", value1, value2, "free4");
            return (Criteria) this;
        }

        public Criteria andFree5IsNull() {
            addCriterion("free5 is null");
            return (Criteria) this;
        }

        public Criteria andFree5IsNotNull() {
            addCriterion("free5 is not null");
            return (Criteria) this;
        }

        public Criteria andFree5EqualTo(String value) {
            addCriterion("free5 =", value, "free5");
            return (Criteria) this;
        }

        public Criteria andFree5NotEqualTo(String value) {
            addCriterion("free5 <>", value, "free5");
            return (Criteria) this;
        }

        public Criteria andFree5GreaterThan(String value) {
            addCriterion("free5 >", value, "free5");
            return (Criteria) this;
        }

        public Criteria andFree5GreaterThanOrEqualTo(String value) {
            addCriterion("free5 >=", value, "free5");
            return (Criteria) this;
        }

        public Criteria andFree5LessThan(String value) {
            addCriterion("free5 <", value, "free5");
            return (Criteria) this;
        }

        public Criteria andFree5LessThanOrEqualTo(String value) {
            addCriterion("free5 <=", value, "free5");
            return (Criteria) this;
        }

        public Criteria andFree5Like(String value) {
            addCriterion("free5 like", value, "free5");
            return (Criteria) this;
        }

        public Criteria andFree5NotLike(String value) {
            addCriterion("free5 not like", value, "free5");
            return (Criteria) this;
        }

        public Criteria andFree5In(List<String> values) {
            addCriterion("free5 in", values, "free5");
            return (Criteria) this;
        }

        public Criteria andFree5NotIn(List<String> values) {
            addCriterion("free5 not in", values, "free5");
            return (Criteria) this;
        }

        public Criteria andFree5Between(String value1, String value2) {
            addCriterion("free5 between", value1, value2, "free5");
            return (Criteria) this;
        }

        public Criteria andFree5NotBetween(String value1, String value2) {
            addCriterion("free5 not between", value1, value2, "free5");
            return (Criteria) this;
        }

        public Criteria andFree6IsNull() {
            addCriterion("free6 is null");
            return (Criteria) this;
        }

        public Criteria andFree6IsNotNull() {
            addCriterion("free6 is not null");
            return (Criteria) this;
        }

        public Criteria andFree6EqualTo(String value) {
            addCriterion("free6 =", value, "free6");
            return (Criteria) this;
        }

        public Criteria andFree6NotEqualTo(String value) {
            addCriterion("free6 <>", value, "free6");
            return (Criteria) this;
        }

        public Criteria andFree6GreaterThan(String value) {
            addCriterion("free6 >", value, "free6");
            return (Criteria) this;
        }

        public Criteria andFree6GreaterThanOrEqualTo(String value) {
            addCriterion("free6 >=", value, "free6");
            return (Criteria) this;
        }

        public Criteria andFree6LessThan(String value) {
            addCriterion("free6 <", value, "free6");
            return (Criteria) this;
        }

        public Criteria andFree6LessThanOrEqualTo(String value) {
            addCriterion("free6 <=", value, "free6");
            return (Criteria) this;
        }

        public Criteria andFree6Like(String value) {
            addCriterion("free6 like", value, "free6");
            return (Criteria) this;
        }

        public Criteria andFree6NotLike(String value) {
            addCriterion("free6 not like", value, "free6");
            return (Criteria) this;
        }

        public Criteria andFree6In(List<String> values) {
            addCriterion("free6 in", values, "free6");
            return (Criteria) this;
        }

        public Criteria andFree6NotIn(List<String> values) {
            addCriterion("free6 not in", values, "free6");
            return (Criteria) this;
        }

        public Criteria andFree6Between(String value1, String value2) {
            addCriterion("free6 between", value1, value2, "free6");
            return (Criteria) this;
        }

        public Criteria andFree6NotBetween(String value1, String value2) {
            addCriterion("free6 not between", value1, value2, "free6");
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