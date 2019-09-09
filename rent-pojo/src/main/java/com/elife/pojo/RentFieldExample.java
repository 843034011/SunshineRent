package com.elife.pojo;

import java.util.ArrayList;
import java.util.List;

public class RentFieldExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RentFieldExample() {
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

        public Criteria andFieldNameIsNull() {
            addCriterion("field_name is null");
            return (Criteria) this;
        }

        public Criteria andFieldNameIsNotNull() {
            addCriterion("field_name is not null");
            return (Criteria) this;
        }

        public Criteria andFieldNameEqualTo(String value) {
            addCriterion("field_name =", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameNotEqualTo(String value) {
            addCriterion("field_name <>", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameGreaterThan(String value) {
            addCriterion("field_name >", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameGreaterThanOrEqualTo(String value) {
            addCriterion("field_name >=", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameLessThan(String value) {
            addCriterion("field_name <", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameLessThanOrEqualTo(String value) {
            addCriterion("field_name <=", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameLike(String value) {
            addCriterion("field_name like", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameNotLike(String value) {
            addCriterion("field_name not like", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameIn(List<String> values) {
            addCriterion("field_name in", values, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameNotIn(List<String> values) {
            addCriterion("field_name not in", values, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameBetween(String value1, String value2) {
            addCriterion("field_name between", value1, value2, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameNotBetween(String value1, String value2) {
            addCriterion("field_name not between", value1, value2, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldTypeIsNull() {
            addCriterion("field_type is null");
            return (Criteria) this;
        }

        public Criteria andFieldTypeIsNotNull() {
            addCriterion("field_type is not null");
            return (Criteria) this;
        }

        public Criteria andFieldTypeEqualTo(String value) {
            addCriterion("field_type =", value, "fieldType");
            return (Criteria) this;
        }

        public Criteria andFieldTypeNotEqualTo(String value) {
            addCriterion("field_type <>", value, "fieldType");
            return (Criteria) this;
        }

        public Criteria andFieldTypeGreaterThan(String value) {
            addCriterion("field_type >", value, "fieldType");
            return (Criteria) this;
        }

        public Criteria andFieldTypeGreaterThanOrEqualTo(String value) {
            addCriterion("field_type >=", value, "fieldType");
            return (Criteria) this;
        }

        public Criteria andFieldTypeLessThan(String value) {
            addCriterion("field_type <", value, "fieldType");
            return (Criteria) this;
        }

        public Criteria andFieldTypeLessThanOrEqualTo(String value) {
            addCriterion("field_type <=", value, "fieldType");
            return (Criteria) this;
        }

        public Criteria andFieldTypeLike(String value) {
            addCriterion("field_type like", value, "fieldType");
            return (Criteria) this;
        }

        public Criteria andFieldTypeNotLike(String value) {
            addCriterion("field_type not like", value, "fieldType");
            return (Criteria) this;
        }

        public Criteria andFieldTypeIn(List<String> values) {
            addCriterion("field_type in", values, "fieldType");
            return (Criteria) this;
        }

        public Criteria andFieldTypeNotIn(List<String> values) {
            addCriterion("field_type not in", values, "fieldType");
            return (Criteria) this;
        }

        public Criteria andFieldTypeBetween(String value1, String value2) {
            addCriterion("field_type between", value1, value2, "fieldType");
            return (Criteria) this;
        }

        public Criteria andFieldTypeNotBetween(String value1, String value2) {
            addCriterion("field_type not between", value1, value2, "fieldType");
            return (Criteria) this;
        }

        public Criteria andFieldInfoIsNull() {
            addCriterion("field_info is null");
            return (Criteria) this;
        }

        public Criteria andFieldInfoIsNotNull() {
            addCriterion("field_info is not null");
            return (Criteria) this;
        }

        public Criteria andFieldInfoEqualTo(String value) {
            addCriterion("field_info =", value, "fieldInfo");
            return (Criteria) this;
        }

        public Criteria andFieldInfoNotEqualTo(String value) {
            addCriterion("field_info <>", value, "fieldInfo");
            return (Criteria) this;
        }

        public Criteria andFieldInfoGreaterThan(String value) {
            addCriterion("field_info >", value, "fieldInfo");
            return (Criteria) this;
        }

        public Criteria andFieldInfoGreaterThanOrEqualTo(String value) {
            addCriterion("field_info >=", value, "fieldInfo");
            return (Criteria) this;
        }

        public Criteria andFieldInfoLessThan(String value) {
            addCriterion("field_info <", value, "fieldInfo");
            return (Criteria) this;
        }

        public Criteria andFieldInfoLessThanOrEqualTo(String value) {
            addCriterion("field_info <=", value, "fieldInfo");
            return (Criteria) this;
        }

        public Criteria andFieldInfoLike(String value) {
            addCriterion("field_info like", value, "fieldInfo");
            return (Criteria) this;
        }

        public Criteria andFieldInfoNotLike(String value) {
            addCriterion("field_info not like", value, "fieldInfo");
            return (Criteria) this;
        }

        public Criteria andFieldInfoIn(List<String> values) {
            addCriterion("field_info in", values, "fieldInfo");
            return (Criteria) this;
        }

        public Criteria andFieldInfoNotIn(List<String> values) {
            addCriterion("field_info not in", values, "fieldInfo");
            return (Criteria) this;
        }

        public Criteria andFieldInfoBetween(String value1, String value2) {
            addCriterion("field_info between", value1, value2, "fieldInfo");
            return (Criteria) this;
        }

        public Criteria andFieldInfoNotBetween(String value1, String value2) {
            addCriterion("field_info not between", value1, value2, "fieldInfo");
            return (Criteria) this;
        }

        public Criteria andFieldDepositIsNull() {
            addCriterion("field_deposit is null");
            return (Criteria) this;
        }

        public Criteria andFieldDepositIsNotNull() {
            addCriterion("field_deposit is not null");
            return (Criteria) this;
        }

        public Criteria andFieldDepositEqualTo(Long value) {
            addCriterion("field_deposit =", value, "fieldDeposit");
            return (Criteria) this;
        }

        public Criteria andFieldDepositNotEqualTo(Long value) {
            addCriterion("field_deposit <>", value, "fieldDeposit");
            return (Criteria) this;
        }

        public Criteria andFieldDepositGreaterThan(Long value) {
            addCriterion("field_deposit >", value, "fieldDeposit");
            return (Criteria) this;
        }

        public Criteria andFieldDepositGreaterThanOrEqualTo(Long value) {
            addCriterion("field_deposit >=", value, "fieldDeposit");
            return (Criteria) this;
        }

        public Criteria andFieldDepositLessThan(Long value) {
            addCriterion("field_deposit <", value, "fieldDeposit");
            return (Criteria) this;
        }

        public Criteria andFieldDepositLessThanOrEqualTo(Long value) {
            addCriterion("field_deposit <=", value, "fieldDeposit");
            return (Criteria) this;
        }

        public Criteria andFieldDepositIn(List<Long> values) {
            addCriterion("field_deposit in", values, "fieldDeposit");
            return (Criteria) this;
        }

        public Criteria andFieldDepositNotIn(List<Long> values) {
            addCriterion("field_deposit not in", values, "fieldDeposit");
            return (Criteria) this;
        }

        public Criteria andFieldDepositBetween(Long value1, Long value2) {
            addCriterion("field_deposit between", value1, value2, "fieldDeposit");
            return (Criteria) this;
        }

        public Criteria andFieldDepositNotBetween(Long value1, Long value2) {
            addCriterion("field_deposit not between", value1, value2, "fieldDeposit");
            return (Criteria) this;
        }

        public Criteria andFieldHourpriceIsNull() {
            addCriterion("field_hourprice is null");
            return (Criteria) this;
        }

        public Criteria andFieldHourpriceIsNotNull() {
            addCriterion("field_hourprice is not null");
            return (Criteria) this;
        }

        public Criteria andFieldHourpriceEqualTo(Long value) {
            addCriterion("field_hourprice =", value, "fieldHourprice");
            return (Criteria) this;
        }

        public Criteria andFieldHourpriceNotEqualTo(Long value) {
            addCriterion("field_hourprice <>", value, "fieldHourprice");
            return (Criteria) this;
        }

        public Criteria andFieldHourpriceGreaterThan(Long value) {
            addCriterion("field_hourprice >", value, "fieldHourprice");
            return (Criteria) this;
        }

        public Criteria andFieldHourpriceGreaterThanOrEqualTo(Long value) {
            addCriterion("field_hourprice >=", value, "fieldHourprice");
            return (Criteria) this;
        }

        public Criteria andFieldHourpriceLessThan(Long value) {
            addCriterion("field_hourprice <", value, "fieldHourprice");
            return (Criteria) this;
        }

        public Criteria andFieldHourpriceLessThanOrEqualTo(Long value) {
            addCriterion("field_hourprice <=", value, "fieldHourprice");
            return (Criteria) this;
        }

        public Criteria andFieldHourpriceIn(List<Long> values) {
            addCriterion("field_hourprice in", values, "fieldHourprice");
            return (Criteria) this;
        }

        public Criteria andFieldHourpriceNotIn(List<Long> values) {
            addCriterion("field_hourprice not in", values, "fieldHourprice");
            return (Criteria) this;
        }

        public Criteria andFieldHourpriceBetween(Long value1, Long value2) {
            addCriterion("field_hourprice between", value1, value2, "fieldHourprice");
            return (Criteria) this;
        }

        public Criteria andFieldHourpriceNotBetween(Long value1, Long value2) {
            addCriterion("field_hourprice not between", value1, value2, "fieldHourprice");
            return (Criteria) this;
        }

        public Criteria andFieldDaypriceIsNull() {
            addCriterion("field_dayprice is null");
            return (Criteria) this;
        }

        public Criteria andFieldDaypriceIsNotNull() {
            addCriterion("field_dayprice is not null");
            return (Criteria) this;
        }

        public Criteria andFieldDaypriceEqualTo(Long value) {
            addCriterion("field_dayprice =", value, "fieldDayprice");
            return (Criteria) this;
        }

        public Criteria andFieldDaypriceNotEqualTo(Long value) {
            addCriterion("field_dayprice <>", value, "fieldDayprice");
            return (Criteria) this;
        }

        public Criteria andFieldDaypriceGreaterThan(Long value) {
            addCriterion("field_dayprice >", value, "fieldDayprice");
            return (Criteria) this;
        }

        public Criteria andFieldDaypriceGreaterThanOrEqualTo(Long value) {
            addCriterion("field_dayprice >=", value, "fieldDayprice");
            return (Criteria) this;
        }

        public Criteria andFieldDaypriceLessThan(Long value) {
            addCriterion("field_dayprice <", value, "fieldDayprice");
            return (Criteria) this;
        }

        public Criteria andFieldDaypriceLessThanOrEqualTo(Long value) {
            addCriterion("field_dayprice <=", value, "fieldDayprice");
            return (Criteria) this;
        }

        public Criteria andFieldDaypriceIn(List<Long> values) {
            addCriterion("field_dayprice in", values, "fieldDayprice");
            return (Criteria) this;
        }

        public Criteria andFieldDaypriceNotIn(List<Long> values) {
            addCriterion("field_dayprice not in", values, "fieldDayprice");
            return (Criteria) this;
        }

        public Criteria andFieldDaypriceBetween(Long value1, Long value2) {
            addCriterion("field_dayprice between", value1, value2, "fieldDayprice");
            return (Criteria) this;
        }

        public Criteria andFieldDaypriceNotBetween(Long value1, Long value2) {
            addCriterion("field_dayprice not between", value1, value2, "fieldDayprice");
            return (Criteria) this;
        }

        public Criteria andFieldWeekpriceIsNull() {
            addCriterion("field_weekprice is null");
            return (Criteria) this;
        }

        public Criteria andFieldWeekpriceIsNotNull() {
            addCriterion("field_weekprice is not null");
            return (Criteria) this;
        }

        public Criteria andFieldWeekpriceEqualTo(Long value) {
            addCriterion("field_weekprice =", value, "fieldWeekprice");
            return (Criteria) this;
        }

        public Criteria andFieldWeekpriceNotEqualTo(Long value) {
            addCriterion("field_weekprice <>", value, "fieldWeekprice");
            return (Criteria) this;
        }

        public Criteria andFieldWeekpriceGreaterThan(Long value) {
            addCriterion("field_weekprice >", value, "fieldWeekprice");
            return (Criteria) this;
        }

        public Criteria andFieldWeekpriceGreaterThanOrEqualTo(Long value) {
            addCriterion("field_weekprice >=", value, "fieldWeekprice");
            return (Criteria) this;
        }

        public Criteria andFieldWeekpriceLessThan(Long value) {
            addCriterion("field_weekprice <", value, "fieldWeekprice");
            return (Criteria) this;
        }

        public Criteria andFieldWeekpriceLessThanOrEqualTo(Long value) {
            addCriterion("field_weekprice <=", value, "fieldWeekprice");
            return (Criteria) this;
        }

        public Criteria andFieldWeekpriceIn(List<Long> values) {
            addCriterion("field_weekprice in", values, "fieldWeekprice");
            return (Criteria) this;
        }

        public Criteria andFieldWeekpriceNotIn(List<Long> values) {
            addCriterion("field_weekprice not in", values, "fieldWeekprice");
            return (Criteria) this;
        }

        public Criteria andFieldWeekpriceBetween(Long value1, Long value2) {
            addCriterion("field_weekprice between", value1, value2, "fieldWeekprice");
            return (Criteria) this;
        }

        public Criteria andFieldWeekpriceNotBetween(Long value1, Long value2) {
            addCriterion("field_weekprice not between", value1, value2, "fieldWeekprice");
            return (Criteria) this;
        }

        public Criteria andFieldMonthpriceIsNull() {
            addCriterion("field_monthprice is null");
            return (Criteria) this;
        }

        public Criteria andFieldMonthpriceIsNotNull() {
            addCriterion("field_monthprice is not null");
            return (Criteria) this;
        }

        public Criteria andFieldMonthpriceEqualTo(Long value) {
            addCriterion("field_monthprice =", value, "fieldMonthprice");
            return (Criteria) this;
        }

        public Criteria andFieldMonthpriceNotEqualTo(Long value) {
            addCriterion("field_monthprice <>", value, "fieldMonthprice");
            return (Criteria) this;
        }

        public Criteria andFieldMonthpriceGreaterThan(Long value) {
            addCriterion("field_monthprice >", value, "fieldMonthprice");
            return (Criteria) this;
        }

        public Criteria andFieldMonthpriceGreaterThanOrEqualTo(Long value) {
            addCriterion("field_monthprice >=", value, "fieldMonthprice");
            return (Criteria) this;
        }

        public Criteria andFieldMonthpriceLessThan(Long value) {
            addCriterion("field_monthprice <", value, "fieldMonthprice");
            return (Criteria) this;
        }

        public Criteria andFieldMonthpriceLessThanOrEqualTo(Long value) {
            addCriterion("field_monthprice <=", value, "fieldMonthprice");
            return (Criteria) this;
        }

        public Criteria andFieldMonthpriceIn(List<Long> values) {
            addCriterion("field_monthprice in", values, "fieldMonthprice");
            return (Criteria) this;
        }

        public Criteria andFieldMonthpriceNotIn(List<Long> values) {
            addCriterion("field_monthprice not in", values, "fieldMonthprice");
            return (Criteria) this;
        }

        public Criteria andFieldMonthpriceBetween(Long value1, Long value2) {
            addCriterion("field_monthprice between", value1, value2, "fieldMonthprice");
            return (Criteria) this;
        }

        public Criteria andFieldMonthpriceNotBetween(Long value1, Long value2) {
            addCriterion("field_monthprice not between", value1, value2, "fieldMonthprice");
            return (Criteria) this;
        }

        public Criteria andFieldAddressIsNull() {
            addCriterion("field_address is null");
            return (Criteria) this;
        }

        public Criteria andFieldAddressIsNotNull() {
            addCriterion("field_address is not null");
            return (Criteria) this;
        }

        public Criteria andFieldAddressEqualTo(String value) {
            addCriterion("field_address =", value, "fieldAddress");
            return (Criteria) this;
        }

        public Criteria andFieldAddressNotEqualTo(String value) {
            addCriterion("field_address <>", value, "fieldAddress");
            return (Criteria) this;
        }

        public Criteria andFieldAddressGreaterThan(String value) {
            addCriterion("field_address >", value, "fieldAddress");
            return (Criteria) this;
        }

        public Criteria andFieldAddressGreaterThanOrEqualTo(String value) {
            addCriterion("field_address >=", value, "fieldAddress");
            return (Criteria) this;
        }

        public Criteria andFieldAddressLessThan(String value) {
            addCriterion("field_address <", value, "fieldAddress");
            return (Criteria) this;
        }

        public Criteria andFieldAddressLessThanOrEqualTo(String value) {
            addCriterion("field_address <=", value, "fieldAddress");
            return (Criteria) this;
        }

        public Criteria andFieldAddressLike(String value) {
            addCriterion("field_address like", value, "fieldAddress");
            return (Criteria) this;
        }

        public Criteria andFieldAddressNotLike(String value) {
            addCriterion("field_address not like", value, "fieldAddress");
            return (Criteria) this;
        }

        public Criteria andFieldAddressIn(List<String> values) {
            addCriterion("field_address in", values, "fieldAddress");
            return (Criteria) this;
        }

        public Criteria andFieldAddressNotIn(List<String> values) {
            addCriterion("field_address not in", values, "fieldAddress");
            return (Criteria) this;
        }

        public Criteria andFieldAddressBetween(String value1, String value2) {
            addCriterion("field_address between", value1, value2, "fieldAddress");
            return (Criteria) this;
        }

        public Criteria andFieldAddressNotBetween(String value1, String value2) {
            addCriterion("field_address not between", value1, value2, "fieldAddress");
            return (Criteria) this;
        }

        public Criteria andFieldGradeIsNull() {
            addCriterion("field_grade is null");
            return (Criteria) this;
        }

        public Criteria andFieldGradeIsNotNull() {
            addCriterion("field_grade is not null");
            return (Criteria) this;
        }

        public Criteria andFieldGradeEqualTo(Integer value) {
            addCriterion("field_grade =", value, "fieldGrade");
            return (Criteria) this;
        }

        public Criteria andFieldGradeNotEqualTo(Integer value) {
            addCriterion("field_grade <>", value, "fieldGrade");
            return (Criteria) this;
        }

        public Criteria andFieldGradeGreaterThan(Integer value) {
            addCriterion("field_grade >", value, "fieldGrade");
            return (Criteria) this;
        }

        public Criteria andFieldGradeGreaterThanOrEqualTo(Integer value) {
            addCriterion("field_grade >=", value, "fieldGrade");
            return (Criteria) this;
        }

        public Criteria andFieldGradeLessThan(Integer value) {
            addCriterion("field_grade <", value, "fieldGrade");
            return (Criteria) this;
        }

        public Criteria andFieldGradeLessThanOrEqualTo(Integer value) {
            addCriterion("field_grade <=", value, "fieldGrade");
            return (Criteria) this;
        }

        public Criteria andFieldGradeIn(List<Integer> values) {
            addCriterion("field_grade in", values, "fieldGrade");
            return (Criteria) this;
        }

        public Criteria andFieldGradeNotIn(List<Integer> values) {
            addCriterion("field_grade not in", values, "fieldGrade");
            return (Criteria) this;
        }

        public Criteria andFieldGradeBetween(Integer value1, Integer value2) {
            addCriterion("field_grade between", value1, value2, "fieldGrade");
            return (Criteria) this;
        }

        public Criteria andFieldGradeNotBetween(Integer value1, Integer value2) {
            addCriterion("field_grade not between", value1, value2, "fieldGrade");
            return (Criteria) this;
        }

        public Criteria andRentCountIsNull() {
            addCriterion("rent_count is null");
            return (Criteria) this;
        }

        public Criteria andRentCountIsNotNull() {
            addCriterion("rent_count is not null");
            return (Criteria) this;
        }

        public Criteria andRentCountEqualTo(Integer value) {
            addCriterion("rent_count =", value, "rentCount");
            return (Criteria) this;
        }

        public Criteria andRentCountNotEqualTo(Integer value) {
            addCriterion("rent_count <>", value, "rentCount");
            return (Criteria) this;
        }

        public Criteria andRentCountGreaterThan(Integer value) {
            addCriterion("rent_count >", value, "rentCount");
            return (Criteria) this;
        }

        public Criteria andRentCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("rent_count >=", value, "rentCount");
            return (Criteria) this;
        }

        public Criteria andRentCountLessThan(Integer value) {
            addCriterion("rent_count <", value, "rentCount");
            return (Criteria) this;
        }

        public Criteria andRentCountLessThanOrEqualTo(Integer value) {
            addCriterion("rent_count <=", value, "rentCount");
            return (Criteria) this;
        }

        public Criteria andRentCountIn(List<Integer> values) {
            addCriterion("rent_count in", values, "rentCount");
            return (Criteria) this;
        }

        public Criteria andRentCountNotIn(List<Integer> values) {
            addCriterion("rent_count not in", values, "rentCount");
            return (Criteria) this;
        }

        public Criteria andRentCountBetween(Integer value1, Integer value2) {
            addCriterion("rent_count between", value1, value2, "rentCount");
            return (Criteria) this;
        }

        public Criteria andRentCountNotBetween(Integer value1, Integer value2) {
            addCriterion("rent_count not between", value1, value2, "rentCount");
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