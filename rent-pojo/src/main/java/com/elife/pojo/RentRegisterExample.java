package com.elife.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RentRegisterExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RentRegisterExample() {
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

        public Criteria andRegIdIsNull() {
            addCriterion("reg_id is null");
            return (Criteria) this;
        }

        public Criteria andRegIdIsNotNull() {
            addCriterion("reg_id is not null");
            return (Criteria) this;
        }

        public Criteria andRegIdEqualTo(Integer value) {
            addCriterion("reg_id =", value, "regId");
            return (Criteria) this;
        }

        public Criteria andRegIdNotEqualTo(Integer value) {
            addCriterion("reg_id <>", value, "regId");
            return (Criteria) this;
        }

        public Criteria andRegIdGreaterThan(Integer value) {
            addCriterion("reg_id >", value, "regId");
            return (Criteria) this;
        }

        public Criteria andRegIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("reg_id >=", value, "regId");
            return (Criteria) this;
        }

        public Criteria andRegIdLessThan(Integer value) {
            addCriterion("reg_id <", value, "regId");
            return (Criteria) this;
        }

        public Criteria andRegIdLessThanOrEqualTo(Integer value) {
            addCriterion("reg_id <=", value, "regId");
            return (Criteria) this;
        }

        public Criteria andRegIdIn(List<Integer> values) {
            addCriterion("reg_id in", values, "regId");
            return (Criteria) this;
        }

        public Criteria andRegIdNotIn(List<Integer> values) {
            addCriterion("reg_id not in", values, "regId");
            return (Criteria) this;
        }

        public Criteria andRegIdBetween(Integer value1, Integer value2) {
            addCriterion("reg_id between", value1, value2, "regId");
            return (Criteria) this;
        }

        public Criteria andRegIdNotBetween(Integer value1, Integer value2) {
            addCriterion("reg_id not between", value1, value2, "regId");
            return (Criteria) this;
        }

        public Criteria andRegUsernameIsNull() {
            addCriterion("reg_username is null");
            return (Criteria) this;
        }

        public Criteria andRegUsernameIsNotNull() {
            addCriterion("reg_username is not null");
            return (Criteria) this;
        }

        public Criteria andRegUsernameEqualTo(String value) {
            addCriterion("reg_username =", value, "regUsername");
            return (Criteria) this;
        }

        public Criteria andRegUsernameNotEqualTo(String value) {
            addCriterion("reg_username <>", value, "regUsername");
            return (Criteria) this;
        }

        public Criteria andRegUsernameGreaterThan(String value) {
            addCriterion("reg_username >", value, "regUsername");
            return (Criteria) this;
        }

        public Criteria andRegUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("reg_username >=", value, "regUsername");
            return (Criteria) this;
        }

        public Criteria andRegUsernameLessThan(String value) {
            addCriterion("reg_username <", value, "regUsername");
            return (Criteria) this;
        }

        public Criteria andRegUsernameLessThanOrEqualTo(String value) {
            addCriterion("reg_username <=", value, "regUsername");
            return (Criteria) this;
        }

        public Criteria andRegUsernameLike(String value) {
            addCriterion("reg_username like", value, "regUsername");
            return (Criteria) this;
        }

        public Criteria andRegUsernameNotLike(String value) {
            addCriterion("reg_username not like", value, "regUsername");
            return (Criteria) this;
        }

        public Criteria andRegUsernameIn(List<String> values) {
            addCriterion("reg_username in", values, "regUsername");
            return (Criteria) this;
        }

        public Criteria andRegUsernameNotIn(List<String> values) {
            addCriterion("reg_username not in", values, "regUsername");
            return (Criteria) this;
        }

        public Criteria andRegUsernameBetween(String value1, String value2) {
            addCriterion("reg_username between", value1, value2, "regUsername");
            return (Criteria) this;
        }

        public Criteria andRegUsernameNotBetween(String value1, String value2) {
            addCriterion("reg_username not between", value1, value2, "regUsername");
            return (Criteria) this;
        }

        public Criteria andRegPasswordIsNull() {
            addCriterion("reg_password is null");
            return (Criteria) this;
        }

        public Criteria andRegPasswordIsNotNull() {
            addCriterion("reg_password is not null");
            return (Criteria) this;
        }

        public Criteria andRegPasswordEqualTo(String value) {
            addCriterion("reg_password =", value, "regPassword");
            return (Criteria) this;
        }

        public Criteria andRegPasswordNotEqualTo(String value) {
            addCriterion("reg_password <>", value, "regPassword");
            return (Criteria) this;
        }

        public Criteria andRegPasswordGreaterThan(String value) {
            addCriterion("reg_password >", value, "regPassword");
            return (Criteria) this;
        }

        public Criteria andRegPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("reg_password >=", value, "regPassword");
            return (Criteria) this;
        }

        public Criteria andRegPasswordLessThan(String value) {
            addCriterion("reg_password <", value, "regPassword");
            return (Criteria) this;
        }

        public Criteria andRegPasswordLessThanOrEqualTo(String value) {
            addCriterion("reg_password <=", value, "regPassword");
            return (Criteria) this;
        }

        public Criteria andRegPasswordLike(String value) {
            addCriterion("reg_password like", value, "regPassword");
            return (Criteria) this;
        }

        public Criteria andRegPasswordNotLike(String value) {
            addCriterion("reg_password not like", value, "regPassword");
            return (Criteria) this;
        }

        public Criteria andRegPasswordIn(List<String> values) {
            addCriterion("reg_password in", values, "regPassword");
            return (Criteria) this;
        }

        public Criteria andRegPasswordNotIn(List<String> values) {
            addCriterion("reg_password not in", values, "regPassword");
            return (Criteria) this;
        }

        public Criteria andRegPasswordBetween(String value1, String value2) {
            addCriterion("reg_password between", value1, value2, "regPassword");
            return (Criteria) this;
        }

        public Criteria andRegPasswordNotBetween(String value1, String value2) {
            addCriterion("reg_password not between", value1, value2, "regPassword");
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