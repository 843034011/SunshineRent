package com.elife.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RentGoodsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RentGoodsExample() {
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

        public Criteria andGoodsNameIsNull() {
            addCriterion("goods_name is null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNotNull() {
            addCriterion("goods_name is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameEqualTo(String value) {
            addCriterion("goods_name =", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotEqualTo(String value) {
            addCriterion("goods_name <>", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThan(String value) {
            addCriterion("goods_name >", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThanOrEqualTo(String value) {
            addCriterion("goods_name >=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThan(String value) {
            addCriterion("goods_name <", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThanOrEqualTo(String value) {
            addCriterion("goods_name <=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLike(String value) {
            addCriterion("goods_name like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotLike(String value) {
            addCriterion("goods_name not like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIn(List<String> values) {
            addCriterion("goods_name in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotIn(List<String> values) {
            addCriterion("goods_name not in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameBetween(String value1, String value2) {
            addCriterion("goods_name between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotBetween(String value1, String value2) {
            addCriterion("goods_name not between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIsNull() {
            addCriterion("goods_type is null");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIsNotNull() {
            addCriterion("goods_type is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeEqualTo(String value) {
            addCriterion("goods_type =", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeNotEqualTo(String value) {
            addCriterion("goods_type <>", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeGreaterThan(String value) {
            addCriterion("goods_type >", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeGreaterThanOrEqualTo(String value) {
            addCriterion("goods_type >=", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeLessThan(String value) {
            addCriterion("goods_type <", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeLessThanOrEqualTo(String value) {
            addCriterion("goods_type <=", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeLike(String value) {
            addCriterion("goods_type like", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeNotLike(String value) {
            addCriterion("goods_type not like", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIn(List<String> values) {
            addCriterion("goods_type in", values, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeNotIn(List<String> values) {
            addCriterion("goods_type not in", values, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeBetween(String value1, String value2) {
            addCriterion("goods_type between", value1, value2, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeNotBetween(String value1, String value2) {
            addCriterion("goods_type not between", value1, value2, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsModelIsNull() {
            addCriterion("goods_model is null");
            return (Criteria) this;
        }

        public Criteria andGoodsModelIsNotNull() {
            addCriterion("goods_model is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsModelEqualTo(String value) {
            addCriterion("goods_model =", value, "goodsModel");
            return (Criteria) this;
        }

        public Criteria andGoodsModelNotEqualTo(String value) {
            addCriterion("goods_model <>", value, "goodsModel");
            return (Criteria) this;
        }

        public Criteria andGoodsModelGreaterThan(String value) {
            addCriterion("goods_model >", value, "goodsModel");
            return (Criteria) this;
        }

        public Criteria andGoodsModelGreaterThanOrEqualTo(String value) {
            addCriterion("goods_model >=", value, "goodsModel");
            return (Criteria) this;
        }

        public Criteria andGoodsModelLessThan(String value) {
            addCriterion("goods_model <", value, "goodsModel");
            return (Criteria) this;
        }

        public Criteria andGoodsModelLessThanOrEqualTo(String value) {
            addCriterion("goods_model <=", value, "goodsModel");
            return (Criteria) this;
        }

        public Criteria andGoodsModelLike(String value) {
            addCriterion("goods_model like", value, "goodsModel");
            return (Criteria) this;
        }

        public Criteria andGoodsModelNotLike(String value) {
            addCriterion("goods_model not like", value, "goodsModel");
            return (Criteria) this;
        }

        public Criteria andGoodsModelIn(List<String> values) {
            addCriterion("goods_model in", values, "goodsModel");
            return (Criteria) this;
        }

        public Criteria andGoodsModelNotIn(List<String> values) {
            addCriterion("goods_model not in", values, "goodsModel");
            return (Criteria) this;
        }

        public Criteria andGoodsModelBetween(String value1, String value2) {
            addCriterion("goods_model between", value1, value2, "goodsModel");
            return (Criteria) this;
        }

        public Criteria andGoodsModelNotBetween(String value1, String value2) {
            addCriterion("goods_model not between", value1, value2, "goodsModel");
            return (Criteria) this;
        }

        public Criteria andGoodsInfoIsNull() {
            addCriterion("goods_info is null");
            return (Criteria) this;
        }

        public Criteria andGoodsInfoIsNotNull() {
            addCriterion("goods_info is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsInfoEqualTo(String value) {
            addCriterion("goods_info =", value, "goodsInfo");
            return (Criteria) this;
        }

        public Criteria andGoodsInfoNotEqualTo(String value) {
            addCriterion("goods_info <>", value, "goodsInfo");
            return (Criteria) this;
        }

        public Criteria andGoodsInfoGreaterThan(String value) {
            addCriterion("goods_info >", value, "goodsInfo");
            return (Criteria) this;
        }

        public Criteria andGoodsInfoGreaterThanOrEqualTo(String value) {
            addCriterion("goods_info >=", value, "goodsInfo");
            return (Criteria) this;
        }

        public Criteria andGoodsInfoLessThan(String value) {
            addCriterion("goods_info <", value, "goodsInfo");
            return (Criteria) this;
        }

        public Criteria andGoodsInfoLessThanOrEqualTo(String value) {
            addCriterion("goods_info <=", value, "goodsInfo");
            return (Criteria) this;
        }

        public Criteria andGoodsInfoLike(String value) {
            addCriterion("goods_info like", value, "goodsInfo");
            return (Criteria) this;
        }

        public Criteria andGoodsInfoNotLike(String value) {
            addCriterion("goods_info not like", value, "goodsInfo");
            return (Criteria) this;
        }

        public Criteria andGoodsInfoIn(List<String> values) {
            addCriterion("goods_info in", values, "goodsInfo");
            return (Criteria) this;
        }

        public Criteria andGoodsInfoNotIn(List<String> values) {
            addCriterion("goods_info not in", values, "goodsInfo");
            return (Criteria) this;
        }

        public Criteria andGoodsInfoBetween(String value1, String value2) {
            addCriterion("goods_info between", value1, value2, "goodsInfo");
            return (Criteria) this;
        }

        public Criteria andGoodsInfoNotBetween(String value1, String value2) {
            addCriterion("goods_info not between", value1, value2, "goodsInfo");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberIsNull() {
            addCriterion("goods_number is null");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberIsNotNull() {
            addCriterion("goods_number is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberEqualTo(Integer value) {
            addCriterion("goods_number =", value, "goodsNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberNotEqualTo(Integer value) {
            addCriterion("goods_number <>", value, "goodsNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberGreaterThan(Integer value) {
            addCriterion("goods_number >", value, "goodsNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_number >=", value, "goodsNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberLessThan(Integer value) {
            addCriterion("goods_number <", value, "goodsNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberLessThanOrEqualTo(Integer value) {
            addCriterion("goods_number <=", value, "goodsNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberIn(List<Integer> values) {
            addCriterion("goods_number in", values, "goodsNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberNotIn(List<Integer> values) {
            addCriterion("goods_number not in", values, "goodsNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberBetween(Integer value1, Integer value2) {
            addCriterion("goods_number between", value1, value2, "goodsNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_number not between", value1, value2, "goodsNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsSurplusIsNull() {
            addCriterion("goods_surplus is null");
            return (Criteria) this;
        }

        public Criteria andGoodsSurplusIsNotNull() {
            addCriterion("goods_surplus is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsSurplusEqualTo(Integer value) {
            addCriterion("goods_surplus =", value, "goodsSurplus");
            return (Criteria) this;
        }

        public Criteria andGoodsSurplusNotEqualTo(Integer value) {
            addCriterion("goods_surplus <>", value, "goodsSurplus");
            return (Criteria) this;
        }

        public Criteria andGoodsSurplusGreaterThan(Integer value) {
            addCriterion("goods_surplus >", value, "goodsSurplus");
            return (Criteria) this;
        }

        public Criteria andGoodsSurplusGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_surplus >=", value, "goodsSurplus");
            return (Criteria) this;
        }

        public Criteria andGoodsSurplusLessThan(Integer value) {
            addCriterion("goods_surplus <", value, "goodsSurplus");
            return (Criteria) this;
        }

        public Criteria andGoodsSurplusLessThanOrEqualTo(Integer value) {
            addCriterion("goods_surplus <=", value, "goodsSurplus");
            return (Criteria) this;
        }

        public Criteria andGoodsSurplusIn(List<Integer> values) {
            addCriterion("goods_surplus in", values, "goodsSurplus");
            return (Criteria) this;
        }

        public Criteria andGoodsSurplusNotIn(List<Integer> values) {
            addCriterion("goods_surplus not in", values, "goodsSurplus");
            return (Criteria) this;
        }

        public Criteria andGoodsSurplusBetween(Integer value1, Integer value2) {
            addCriterion("goods_surplus between", value1, value2, "goodsSurplus");
            return (Criteria) this;
        }

        public Criteria andGoodsSurplusNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_surplus not between", value1, value2, "goodsSurplus");
            return (Criteria) this;
        }

        public Criteria andGoodsDepositIsNull() {
            addCriterion("goods_deposit is null");
            return (Criteria) this;
        }

        public Criteria andGoodsDepositIsNotNull() {
            addCriterion("goods_deposit is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsDepositEqualTo(Long value) {
            addCriterion("goods_deposit =", value, "goodsDeposit");
            return (Criteria) this;
        }

        public Criteria andGoodsDepositNotEqualTo(Long value) {
            addCriterion("goods_deposit <>", value, "goodsDeposit");
            return (Criteria) this;
        }

        public Criteria andGoodsDepositGreaterThan(Long value) {
            addCriterion("goods_deposit >", value, "goodsDeposit");
            return (Criteria) this;
        }

        public Criteria andGoodsDepositGreaterThanOrEqualTo(Long value) {
            addCriterion("goods_deposit >=", value, "goodsDeposit");
            return (Criteria) this;
        }

        public Criteria andGoodsDepositLessThan(Long value) {
            addCriterion("goods_deposit <", value, "goodsDeposit");
            return (Criteria) this;
        }

        public Criteria andGoodsDepositLessThanOrEqualTo(Long value) {
            addCriterion("goods_deposit <=", value, "goodsDeposit");
            return (Criteria) this;
        }

        public Criteria andGoodsDepositIn(List<Long> values) {
            addCriterion("goods_deposit in", values, "goodsDeposit");
            return (Criteria) this;
        }

        public Criteria andGoodsDepositNotIn(List<Long> values) {
            addCriterion("goods_deposit not in", values, "goodsDeposit");
            return (Criteria) this;
        }

        public Criteria andGoodsDepositBetween(Long value1, Long value2) {
            addCriterion("goods_deposit between", value1, value2, "goodsDeposit");
            return (Criteria) this;
        }

        public Criteria andGoodsDepositNotBetween(Long value1, Long value2) {
            addCriterion("goods_deposit not between", value1, value2, "goodsDeposit");
            return (Criteria) this;
        }

        public Criteria andGoodsDaypriceIsNull() {
            addCriterion("goods_dayprice is null");
            return (Criteria) this;
        }

        public Criteria andGoodsDaypriceIsNotNull() {
            addCriterion("goods_dayprice is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsDaypriceEqualTo(Long value) {
            addCriterion("goods_dayprice =", value, "goodsDayprice");
            return (Criteria) this;
        }

        public Criteria andGoodsDaypriceNotEqualTo(Long value) {
            addCriterion("goods_dayprice <>", value, "goodsDayprice");
            return (Criteria) this;
        }

        public Criteria andGoodsDaypriceGreaterThan(Long value) {
            addCriterion("goods_dayprice >", value, "goodsDayprice");
            return (Criteria) this;
        }

        public Criteria andGoodsDaypriceGreaterThanOrEqualTo(Long value) {
            addCriterion("goods_dayprice >=", value, "goodsDayprice");
            return (Criteria) this;
        }

        public Criteria andGoodsDaypriceLessThan(Long value) {
            addCriterion("goods_dayprice <", value, "goodsDayprice");
            return (Criteria) this;
        }

        public Criteria andGoodsDaypriceLessThanOrEqualTo(Long value) {
            addCriterion("goods_dayprice <=", value, "goodsDayprice");
            return (Criteria) this;
        }

        public Criteria andGoodsDaypriceIn(List<Long> values) {
            addCriterion("goods_dayprice in", values, "goodsDayprice");
            return (Criteria) this;
        }

        public Criteria andGoodsDaypriceNotIn(List<Long> values) {
            addCriterion("goods_dayprice not in", values, "goodsDayprice");
            return (Criteria) this;
        }

        public Criteria andGoodsDaypriceBetween(Long value1, Long value2) {
            addCriterion("goods_dayprice between", value1, value2, "goodsDayprice");
            return (Criteria) this;
        }

        public Criteria andGoodsDaypriceNotBetween(Long value1, Long value2) {
            addCriterion("goods_dayprice not between", value1, value2, "goodsDayprice");
            return (Criteria) this;
        }

        public Criteria andGoodsWeekpriceIsNull() {
            addCriterion("goods_weekprice is null");
            return (Criteria) this;
        }

        public Criteria andGoodsWeekpriceIsNotNull() {
            addCriterion("goods_weekprice is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsWeekpriceEqualTo(Long value) {
            addCriterion("goods_weekprice =", value, "goodsWeekprice");
            return (Criteria) this;
        }

        public Criteria andGoodsWeekpriceNotEqualTo(Long value) {
            addCriterion("goods_weekprice <>", value, "goodsWeekprice");
            return (Criteria) this;
        }

        public Criteria andGoodsWeekpriceGreaterThan(Long value) {
            addCriterion("goods_weekprice >", value, "goodsWeekprice");
            return (Criteria) this;
        }

        public Criteria andGoodsWeekpriceGreaterThanOrEqualTo(Long value) {
            addCriterion("goods_weekprice >=", value, "goodsWeekprice");
            return (Criteria) this;
        }

        public Criteria andGoodsWeekpriceLessThan(Long value) {
            addCriterion("goods_weekprice <", value, "goodsWeekprice");
            return (Criteria) this;
        }

        public Criteria andGoodsWeekpriceLessThanOrEqualTo(Long value) {
            addCriterion("goods_weekprice <=", value, "goodsWeekprice");
            return (Criteria) this;
        }

        public Criteria andGoodsWeekpriceIn(List<Long> values) {
            addCriterion("goods_weekprice in", values, "goodsWeekprice");
            return (Criteria) this;
        }

        public Criteria andGoodsWeekpriceNotIn(List<Long> values) {
            addCriterion("goods_weekprice not in", values, "goodsWeekprice");
            return (Criteria) this;
        }

        public Criteria andGoodsWeekpriceBetween(Long value1, Long value2) {
            addCriterion("goods_weekprice between", value1, value2, "goodsWeekprice");
            return (Criteria) this;
        }

        public Criteria andGoodsWeekpriceNotBetween(Long value1, Long value2) {
            addCriterion("goods_weekprice not between", value1, value2, "goodsWeekprice");
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

        public Criteria andGoodsGradeIsNull() {
            addCriterion("goods_grade is null");
            return (Criteria) this;
        }

        public Criteria andGoodsGradeIsNotNull() {
            addCriterion("goods_grade is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsGradeEqualTo(Integer value) {
            addCriterion("goods_grade =", value, "goodsGrade");
            return (Criteria) this;
        }

        public Criteria andGoodsGradeNotEqualTo(Integer value) {
            addCriterion("goods_grade <>", value, "goodsGrade");
            return (Criteria) this;
        }

        public Criteria andGoodsGradeGreaterThan(Integer value) {
            addCriterion("goods_grade >", value, "goodsGrade");
            return (Criteria) this;
        }

        public Criteria andGoodsGradeGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_grade >=", value, "goodsGrade");
            return (Criteria) this;
        }

        public Criteria andGoodsGradeLessThan(Integer value) {
            addCriterion("goods_grade <", value, "goodsGrade");
            return (Criteria) this;
        }

        public Criteria andGoodsGradeLessThanOrEqualTo(Integer value) {
            addCriterion("goods_grade <=", value, "goodsGrade");
            return (Criteria) this;
        }

        public Criteria andGoodsGradeIn(List<Integer> values) {
            addCriterion("goods_grade in", values, "goodsGrade");
            return (Criteria) this;
        }

        public Criteria andGoodsGradeNotIn(List<Integer> values) {
            addCriterion("goods_grade not in", values, "goodsGrade");
            return (Criteria) this;
        }

        public Criteria andGoodsGradeBetween(Integer value1, Integer value2) {
            addCriterion("goods_grade between", value1, value2, "goodsGrade");
            return (Criteria) this;
        }

        public Criteria andGoodsGradeNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_grade not between", value1, value2, "goodsGrade");
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