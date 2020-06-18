package ace.user.base.api.web.application.controller;

import ace.fw.model.response.GenericResponseExt;
import ace.user.base.api.web.application.biz.smsverifycode.SmsVerifyCodeCheckEqualBiz;
import ace.user.base.api.web.application.biz.smsverifycode.SmsVerifyCodeGetBiz;
import ace.user.base.api.web.application.biz.smsverifycode.SmsVerifyCodeRemoveBiz;
import ace.user.base.api.web.application.biz.smsverifycode.SmsVerifyCodeSendBiz;
import ace.user.base.define.model.VerifyCodeId;
import ace.user.base.define.model.request.CheckRequest;
import ace.user.base.define.model.request.GetVerifyCodeRequest;
import ace.user.base.define.model.request.SendVerifyCodeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/1/19 11:37
 * @description
 */
@RestController
@Validated
public class SmsVerifyCodeBaseControllerImpl implements SmsVerifyCodeBaseService {

    @Autowired
    private SmsVerifyCodeSendBiz smsVerifyCodeSendBiz;
    @Autowired
    private SmsVerifyCodeGetBiz smsVerifyCodeGetBiz;
    @Autowired
    private SmsVerifyCodeCheckEqualBiz smsVerifyCodeCheckEqualBiz;
    @Autowired
    private SmsVerifyCodeRemoveBiz smsVerifyCodeRemoveBiz;

    @Override
    public GenericResponseExt<String> send(@Valid SendVerifyCodeRequest request) {
        return smsVerifyCodeSendBiz.execute(request);
    }

    @Override
    public GenericResponseExt<String> get(@Valid GetVerifyCodeRequest request) {
        return smsVerifyCodeGetBiz.execute(request);
    }

    @Override
    public GenericResponseExt<Boolean> check(CheckRequest request) {
        return smsVerifyCodeCheckEqualBiz.execute(request);
    }

    @Override
    public GenericResponseExt<Boolean> remove(VerifyCodeId request) {
        return smsVerifyCodeRemoveBiz.execute(request);
    }
}