package com.elife.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class UserShoppingcartExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserShoppingcartExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterionForJDBCDate("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterionForJDBCDate("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterionForJDBCDate("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterionForJDBCDate("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterionForJDBCDate("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterionForJDBCDate("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andFieldIdIsNull() {
            addCriterion("field_id is null");
            return (Criteria) this;
        }

        public Criteria andFieldIdIsNotNull() {
            addCriterion("field_id is not null");
            return (Criteria) this;
        }

        public Criteria andFieldIdEqualTo(Integer value) {
            addCriterion("field_id =", value, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdNotEqualTo(Integer value) {
            addCriterion("field_id <>", value, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdGreaterThan(Integer value) {
            addCriterion("field_id >", value, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("field_id >=", value, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdLessThan(Integer value) {
            addCriterion("field_id <", value, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdLessThanOrEqualTo(Integer value) {
            addCriterion("field_id <=", value, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdIn(List<Integer> values) {
            addCriterion("field_id in", values, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdNotIn(List<Integer> values) {
            addCriterion("field_id not in", values, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdBetween(Integer value1, Integer value2) {
            addCriterion("field_id between", value1, value2, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdNotBetween(Integer value1, Integer value2) {
            addCriterion("field_id not between", value1, value2, "fieldId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNull() {
            addCriterion("goods_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNotNull() {
            addCriterion("goods_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdEqualTo(Integer value) {
            addCriterion("goods_id =", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotEqualTo(Integer value) {
            addCriterion("goods_id <>", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThan(Integer value) {
            addCriterion("goods_id >", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_id >=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThan(Integer value) {
            addCriterion("goods_id <", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThanOrEqualTo(Integer value) {
            addCriterion("goods_id <=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIn(List<Integer> values) {
            addCriterion("goods_id in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotIn(List<Integer> values) {
            addCriterion("goods_id not in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdBetween(Integer value1, Integer value2) {
            addCriterion("goods_id between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_id not between", value1, value2, "goodsId");
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

        public Criteria andExtraInt1IsNull() {
            addCriterion("extra_int1 is null");
            return (Criteria) this;
        }

        public Criteria andExtraInt1IsNotNull() {
            addCriterion("extra_int1 is not null");
            return (Criteria) this;
        }

        public Criteria andExtraInt1EqualTo(Integer value) {
            addCriterion("extra_int1 =", value, "extraInt1");
            return (Criteria) this;
        }

        public Criteria andExtraInt1NotEqualTo(Integer value) {
            addCriterion("extra_int1 <>", value, "extraInt1");
            return (Criteria) this;
        }

        public Criteria andExtraInt1GreaterThan(Integer value) {
            addCriterion("extra_int1 >", value, "extraInt1");
            return (Criteria) this;
        }

        public Criteria andExtraInt1GreaterThanOrEqualTo(Integer value) {
            addCriterion("extra_int1 >=", value, "extraInt1");
            return (Criteria) this;
        }

        public Criteria andExtraInt1LessThan(Integer value) {
            addCriterion("extra_int1 <", value, "extraInt1");
            return (Criteria) this;
        }

        public Criteria andExtraInt1LessThanOrEqualTo(Integer value) {
            addCriterion("extra_int1 <=", value, "extraInt1");
            return (Criteria) this;
        }

        public Criteria andExtraInt1In(List<Integer> values) {
            addCriterion("extra_int1 in", values, "extraInt1");
            return (Criteria) this;
        }

        public Criteria andExtraInt1NotIn(List<Integer> values) {
            addCriterion("extra_int1 not in", values, "extraInt1");
            return (Criteria) this;
        }

        public Criteria andExtraInt1Between(Integer value1, Integer value2) {
            addCriterion("extra_int1 between", value1, value2, "extraInt1");
            return (Criteria) this;
        }

        public Criteria andExtraInt1NotBetween(Integer value1, Integer value2) {
            addCriterion("extra_int1 not between", value1, value2, "extraInt1");
            return (Criteria) this;
        }

        public Criteria andExtraInt2IsNull() {
            addCriterion("extra_int2 is null");
            return (Criteria) this;
        }

        public Criteria andExtraInt2IsNotNull() {
            addCriterion("extra_int2 is not null");
            return (Criteria) this;
        }

        public Criteria andExtraInt2EqualTo(Integer value) {
            addCriterion("extra_int2 =", value, "extraInt2");
            return (Criteria) this;
        }

        public Criteria andExtraInt2NotEqualTo(Integer value) {
            addCriterion("extra_int2 <>", value, "extraInt2");
            return (Criteria) this;
        }

        public Criteria andExtraInt2GreaterThan(Integer value) {
            addCriterion("extra_int2 >", value, "extraInt2");
            return (Criteria) this;
        }

        public Criteria andExtraInt2GreaterThanOrEqualTo(Integer value) {
            addCriterion("extra_int2 >=", value, "extraInt2");
            return (Criteria) this;
        }

        public Criteria andExtraInt2LessThan(Integer value) {
            addCriterion("extra_int2 <", value, "extraInt2");
            return (Criteria) this;
        }

        public Criteria andExtraInt2LessThanOrEqualTo(Integer value) {
            addCriterion("extra_int2 <=", value, "extraInt2");
            return (Criteria) this;
        }

        public Criteria andExtraInt2In(List<Integer> values) {
            addCriterion("extra_int2 in", values, "extraInt2");
            return (Criteria) this;
        }

        public Criteria andExtraInt2NotIn(List<Integer> values) {
            addCriterion("extra_int2 not in", values, "extraInt2");
            return (Criteria) this;
        }

        public Criteria andExtraInt2Between(Integer value1, Integer value2) {
            addCriterion("extra_int2 between", value1, value2, "extraInt2");
            return (Criteria) this;
        }

        public Criteria andExtraInt2NotBetween(Integer value1, Integer value2) {
            addCriterion("extra_int2 not between", value1, value2, "extraInt2");
            return (Criteria) this;
        }

        public Criteria andExtraDecimal1IsNull() {
            addCriterion("extra_decimal1 is null");
            return (Criteria) this;
        }

        public Criteria andExtraDecimal1IsNotNull() {
            addCriterion("extra_decimal1 is not null");
            return (Criteria) this;
        }

        public Criteria andExtraDecimal1EqualTo(Long value) {
            addCriterion("extra_decimal1 =", value, "extraDecimal1");
            return (Criteria) this;
        }

        public Criteria andExtraDecimal1NotEqualTo(Long value) {
            addCriterion("extra_decimal1 <>", value, "extraDecimal1");
            return (Criteria) this;
        }

        public Criteria andExtraDecimal1GreaterThan(Long value) {
            addCriterion("extra_decimal1 >", value, "extraDecimal1");
            return (Criteria) this;
        }

        public Criteria andExtraDecimal1GreaterThanOrEqualTo(Long value) {
            addCriterion("extra_decimal1 >=", value, "extraDecimal1");
            return (Criteria) this;
        }

        public Criteria andExtraDecimal1LessThan(Long value) {
            addCriterion("extra_decimal1 <", value, "extraDecimal1");
            return (Criteria) this;
        }

        public Criteria andExtraDecimal1LessThanOrEqualTo(Long value) {
            addCriterion("extra_decimal1 <=", value, "extraDecimal1");
            return (Criteria) this;
        }

        public Criteria andExtraDecimal1In(List<Long> values) {
            addCriterion("extra_decimal1 in", values, "extraDecimal1");
            return (Criteria) this;
        }

        public Criteria andExtraDecimal1NotIn(List<Long> values) {
            addCriterion("extra_decimal1 not in", values, "extraDecimal1");
            return (Criteria) this;
        }

        public Criteria andExtraDecimal1Between(Long value1, Long value2) {
            addCriterion("extra_decimal1 between", value1, value2, "extraDecimal1");
            return (Criteria) this;
        }

        public Criteria andExtraDecimal1NotBetween(Long value1, Long value2) {
            addCriterion("extra_decimal1 not between", value1, value2, "extraDecimal1");
            return (Criteria) this;
        }

        public Criteria andExtraDecimal2IsNull() {
            addCriterion("extra_decimal2 is null");
            return (Criteria) this;
        }

        public Criteria andExtraDecimal2IsNotNull() {
            addCriterion("extra_decimal2 is not null");
            return (Criteria) this;
        }

        public Criteria andExtraDecimal2EqualTo(Long value) {
            addCriterion("extra_decimal2 =", value, "extraDecimal2");
            return (Criteria) this;
        }

        public Criteria andExtraDecimal2NotEqualTo(Long value) {
            addCriterion("extra_decimal2 <>", value, "extraDecimal2");
            return (Criteria) this;
        }

        public Criteria andExtraDecimal2GreaterThan(Long value) {
            addCriterion("extra_decimal2 >", value, "extraDecimal2");
            return (Criteria) this;
        }

        public Criteria andExtraDecimal2GreaterThanOrEqualTo(Long value) {
            addCriterion("extra_decimal2 >=", value, "extraDecimal2");
            return (Criteria) this;
        }

        public Criteria andExtraDecimal2LessThan(Long value) {
            addCriterion("extra_decimal2 <", value, "extraDecimal2");
            return (Criteria) this;
        }

        public Criteria andExtraDecimal2LessThanOrEqualTo(Long value) {
            addCriterion("extra_decimal2 <=", value, "extraDecimal2");
            return (Criteria) this;
        }

        public Criteria andExtraDecimal2In(List<Long> values) {
            addCriterion("extra_decimal2 in", values, "extraDecimal2");
            return (Criteria) this;
        }

        public Criteria andExtraDecimal2NotIn(List<Long> values) {
            addCriterion("extra_decimal2 not in", values, "extraDecimal2");
            return (Criteria) this;
        }

        public Criteria andExtraDecimal2Between(Long value1, Long value2) {
            addCriterion("extra_decimal2 between", value1, value2, "extraDecimal2");
            return (Criteria) this;
        }

        public Criteria andExtraDecimal2NotBetween(Long value1, Long value2) {
            addCriterion("extra_decimal2 not between", value1, value2, "extraDecimal2");
            return (Criteria) this;
        }

        public Criteria andExtraVarchar1IsNull() {
            addCriterion("extra_varchar1 is null");
            return (Criteria) this;
        }

        public Criteria andExtraVarchar1IsNotNull() {
            addCriterion("extra_varchar1 is not null");
            return (Criteria) this;
        }

        public Criteria andExtraVarchar1EqualTo(String value) {
            addCriterion("extra_varchar1 =", value, "extraVarchar1");
            return (Criteria) this;
        }

        public Criteria andExtraVarchar1NotEqualTo(String value) {
            addCriterion("extra_varchar1 <>", value, "extraVarchar1");
            return (Criteria) this;
        }

        public Criteria andExtraVarchar1GreaterThan(String value) {
            addCriterion("extra_varchar1 >", value, "extraVarchar1");
            return (Criteria) this;
        }

        public Criteria andExtraVarchar1GreaterThanOrEqualTo(String value) {
            addCriterion("extra_varchar1 >=", value, "extraVarchar1");
            return (Criteria) this;
        }

        public Criteria andExtraVarchar1LessThan(String value) {
            addCriterion("extra_varchar1 <", value, "extraVarchar1");
            return (Criteria) this;
        }

        public Criteria andExtraVarchar1LessThanOrEqualTo(String value) {
            addCriterion("extra_varchar1 <=", value, "extraVarchar1");
            return (Criteria) this;
        }

        public Criteria andExtraVarchar1Like(String value) {
            addCriterion("extra_varchar1 like", value, "extraVarchar1");
            return (Criteria) this;
        }

        public Criteria andExtraVarchar1NotLike(String value) {
            addCriterion("extra_varchar1 not like", value, "extraVarchar1");
            return (Criteria) this;
        }

        public Criteria andExtraVarchar1In(List<String> values) {
            addCriterion("extra_varchar1 in", values, "extraVarchar1");
            return (Criteria) this;
        }

        public Criteria andExtraVarchar1NotIn(List<String> values) {
            addCriterion("extra_varchar1 not in", values, "extraVarchar1");
            return (Criteria) this;
        }

        public Criteria andExtraVarchar1Between(String value1, String value2) {
            addCriterion("extra_varchar1 between", value1, value2, "extraVarchar1");
            return (Criteria) this;
        }

        public Criteria andExtraVarchar1NotBetween(String value1, String value2) {
            addCriterion("extra_varchar1 not between", value1, value2, "extraVarchar1");
            return (Criteria) this;
        }

        public Criteria andExtraVarchar2IsNull() {
            addCriterion("extra_varchar2 is null");
            return (Criteria) this;
        }

        public Criteria andExtraVarchar2IsNotNull() {
            addCriterion("extra_varchar2 is not null");
            return (Criteria) this;
        }

        public Criteria andExtraVarchar2EqualTo(String value) {
            addCriterion("extra_varchar2 =", value, "extraVarchar2");
            return (Criteria) this;
        }

        public Criteria andExtraVarchar2NotEqualTo(String value) {
            addCriterion("extra_varchar2 <>", value, "extraVarchar2");
            return (Criteria) this;
        }

        public Criteria andExtraVarchar2GreaterThan(String value) {
            addCriterion("extra_varchar2 >", value, "extraVarchar2");
            return (Criteria) this;
        }

        public Criteria andExtraVarchar2GreaterThanOrEqualTo(String value) {
            addCriterion("extra_varchar2 >=", value, "extraVarchar2");
            return (Criteria) this;
        }

        public Criteria andExtraVarchar2LessThan(String value) {
            addCriterion("extra_varchar2 <", value, "extraVarchar2");
            return (Criteria) this;
        }

        public Criteria andExtraVarchar2LessThanOrEqualTo(String value) {
            addCriterion("extra_varchar2 <=", value, "extraVarchar2");
            return (Criteria) this;
        }

        public Criteria andExtraVarchar2Like(String value) {
            addCriterion("extra_varchar2 like", value, "extraVarchar2");
            return (Criteria) this;
        }

        public Criteria andExtraVarchar2NotLike(String value) {
            addCriterion("extra_varchar2 not like", value, "extraVarchar2");
            return (Criteria) this;
        }

        public Criteria andExtraVarchar2In(List<String> values) {
            addCriterion("extra_varchar2 in", values, "extraVarchar2");
            return (Criteria) this;
        }

        public Criteria andExtraVarchar2NotIn(List<String> values) {
            addCriterion("extra_varchar2 not in", values, "extraVarchar2");
            return (Criteria) this;
        }

        public Criteria andExtraVarchar2Between(String value1, String value2) {
            addCriterion("extra_varchar2 between", value1, value2, "extraVarchar2");
            return (Criteria) this;
        }

        public Criteria andExtraVarchar2NotBetween(String value1, String value2) {
            addCriterion("extra_varchar2 not between", value1, value2, "extraVarchar2");
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