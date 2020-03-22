package io.seata.samples.tcc.dubbo.action;

import java.util.List;

import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.BusinessActionContextParameter;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;

/**
 * The interface Tcc saga.io.seata.samples.action two.
 *
 * @author zhangsen
 */
public interface TccActionTwo {

    /**
     * Prepare boolean.
     *
     * @param actionContext the saga.io.seata.samples.action context
     * @param b             the b
     * @param list          the list
     * @return the boolean
     */
    @TwoPhaseBusinessAction(name = "DubboTccActionTwo" , commitMethod = "commit", rollbackMethod = "rollback")
    public boolean prepare(BusinessActionContext actionContext, @BusinessActionContextParameter(paramName = "b") String b,
                           @BusinessActionContextParameter(paramName = "c",index = 1) List list);

    /**
     * Commit boolean.
     *
     * @param actionContext the saga.io.seata.samples.action context
     * @return the boolean
     */
    public boolean commit(BusinessActionContext actionContext);

    /**
     * Rollback boolean.
     *
     * @param actionContext the saga.io.seata.samples.action context
     * @return the boolean
     */
    public boolean rollback(BusinessActionContext actionContext);

}
