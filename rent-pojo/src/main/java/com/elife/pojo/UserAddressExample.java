package com.elife.pojo;

import java.util.ArrayList;
import java.util.List;

public class UserAddressExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserAddressExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPickerNameIsNull() {
            addCriterion("picker_name is null");
            return (Criteria) this;
        }

        public Criteria andPickerNameIsNotNull() {
            addCriterion("picker_name is not null");
            return (Criteria) this;
        }

        public Criteria andPickerNameEqualTo(String value) {
            addCriterion("picker_name =", value, "pickerName");
            return (Criteria) this;
        }

        public Criteria andPickerNameNotEqualTo(String value) {
            addCriterion("picker_name <>", value, "pickerName");
            return (Criteria) this;
        }

        public Criteria andPickerNameGreaterThan(String value) {
            addCriterion("picker_name >", value, "pickerName");
            return (Criteria) this;
        }

        public Criteria andPickerNameGreaterThanOrEqualTo(String value) {
            addCriterion("picker_name >=", value, "pickerName");
            return (Criteria) this;
        }

        public Criteria andPickerNameLessThan(String value) {
            addCriterion("picker_name <", value, "pickerName");
            return (Criteria) this;
        }

        public Criteria andPickerNameLessThanOrEqualTo(String value) {
            addCriterion("picker_name <=", value, "pickerName");
            return (Criteria) this;
        }

        public Criteria andPickerNameLike(String value) {
            addCriterion("picker_name like", value, "pickerName");
            return (Criteria) this;
        }

        public Criteria andPickerNameNotLike(String value) {
            addCriterion("picker_name not like", value, "pickerName");
            return (Criteria) this;
        }

        public Criteria andPickerNameIn(List<String> values) {
            addCriterion("picker_name in", values, "pickerName");
            return (Criteria) this;
        }

        public Criteria andPickerNameNotIn(List<String> values) {
            addCriterion("picker_name not in", values, "pickerName");
            return (Criteria) this;
        }

        public Criteria andPickerNameBetween(String value1, String value2) {
            addCriterion("picker_name between", value1, value2, "pickerName");
            return (Criteria) this;
        }

        public Criteria andPickerNameNotBetween(String value1, String value2) {
            addCriterion("picker_name not between", value1, value2, "pickerName");
            return (Criteria) this;
        }

        public Criteria andPickerPhoneIsNull() {
            addCriterion("picker_phone is null");
            return (Criteria) this;
        }

        public Criteria andPickerPhoneIsNotNull() {
            addCriterion("picker_phone is not null");
            return (Criteria) this;
        }

        public Criteria andPickerPhoneEqualTo(String value) {
            addCriterion("picker_phone =", value, "pickerPhone");
            return (Criteria) this;
        }

        public Criteria andPickerPhoneNotEqualTo(String value) {
            addCriterion("picker_phone <>", value, "pickerPhone");
            return (Criteria) this;
        }

        public Criteria andPickerPhoneGreaterThan(String value) {
            addCriterion("picker_phone >", value, "pickerPhone");
            return (Criteria) this;
        }

        public Criteria andPickerPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("picker_phone >=", value, "pickerPhone");
            return (Criteria) this;
        }

        public Criteria andPickerPhoneLessThan(String value) {
            addCriterion("picker_phone <", value, "pickerPhone");
            return (Criteria) this;
        }

        public Criteria andPickerPhoneLessThanOrEqualTo(String value) {
            addCriterion("picker_phone <=", value, "pickerPhone");
            return (Criteria) this;
        }

        public Criteria andPickerPhoneLike(String value) {
            addCriterion("picker_phone like", value, "pickerPhone");
            return (Criteria) this;
        }

        public Criteria andPickerPhoneNotLike(String value) {
            addCriterion("picker_phone not like", value, "pickerPhone");
            return (Criteria) this;
        }

        public Criteria andPickerPhoneIn(List<String> values) {
            addCriterion("picker_phone in", values, "pickerPhone");
            return (Criteria) this;
        }

        public Criteria andPickerPhoneNotIn(List<String> values) {
            addCriterion("picker_phone not in", values, "pickerPhone");
            return (Criteria) this;
        }

        public Criteria andPickerPhoneBetween(String value1, String value2) {
            addCriterion("picker_phone between", value1, value2, "pickerPhone");
            return (Criteria) this;
        }

        public Criteria andPickerPhoneNotBetween(String value1, String value2) {
            addCriterion("picker_phone not between", value1, value2, "pickerPhone");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
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