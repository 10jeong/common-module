package com.yeoljeong.tripmate.event.enums;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PlanTopic {

  /*
   * 토픽에 대한 컨벤션은 "domain.resource.active"로 합니다. (~가 ~를 한다.)
   */

  public static final String PLAN_UNIT_PARTICIPANT_ADDED_TOPIC = "plan.unit.participant.added";
  public static final String PLAN_UNIT_CONFIRMED_TOPIC = "plan.unit.confirmed";
  public static final String PLAN_UNIT_PARTICIPANT_ADD_FAILED_TOPIC = "plan.unit.participant.add.failed";
  public static final String PLAN_UNIT_PARTICIPANT_DEDUCTED_BY_PRODUCT_TOPIC = "plan.unit.participant.deducted-by-product";
  public static final String PLAN_UNIT_PARTICIPANT_QUIT_TOPIC = "plan.unit.participant.quit";
  public static final String PLAN_UNIT_PARTICIPANT_DEDUCT_FAILED_TOPIC = "plan.unit.participant.deduct.failed";
  public static final String PLAN_UNIT_PARTICIPANT_DEDUCTED_BY_ORDER_TOPIC = "plan.unit.participant.deducted-by-order";

}