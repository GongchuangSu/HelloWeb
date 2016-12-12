package com.gongchuangsu.helloweb.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.dom4j.DocumentException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.gongchuangsu.helloweb.util.WeixinUtil;

@Controller
public class WeixinController {
	
	@RequestMapping(value = "/weixin", method = RequestMethod.GET)
	public void initWeixinURL(
			HttpServletRequest request, HttpServletResponse response) throws IOException{
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");
		
		PrintWriter out = response.getWriter();
		if(WeixinUtil.checkSignature(signature, timestamp, nonce)){
			out.print(echostr);
		}
	}
	
	@RequestMapping(value = "/weixin", method = RequestMethod.POST)
	public void replyMessage(
			HttpServletRequest request, HttpServletResponse response) throws IOException{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		try {
			Map<String, String> map = WeixinUtil.xmlToMap(request);
			String toUserName = map.get("ToUserName");
			String fromUserName = map.get("FromUserName");
			String msgType = map.get("MsgType");
			String content = map.get("Content");
			
			String message = null;
			if(WeixinUtil.MESSAGE_TEXT.equals(msgType)){
				if("时间".equals(content)){
					message = WeixinUtil.initText(toUserName, fromUserName,
							new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
				}else {
					message = WeixinUtil.initText(toUserName, fromUserName, "回复“时间”可获取当前时间！");
				}
			}else if(WeixinUtil.MESSAGE_EVENT.equals(msgType)){
				String eventType = map.get("Event");
				if(WeixinUtil.MESSAGE_SUBSCRIBE.equals(eventType)){
					message = WeixinUtil.initText(toUserName, fromUserName, "终于等到你，还好我没放弃~");
				}
			}
			System.out.println(message);
			out.println(message);
		} catch (IOException | DocumentException e) {
			e.printStackTrace();
		}finally {
			out.close();
		}
	}
}
