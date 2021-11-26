package Command_Controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import Interface.Command;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

public class SMSPushServiceCon implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		//1시간 갱신 ->  실제가격 싸지면 보내지는거였는데 ..이걸 시간 체크해서 
		String api_key = "NCSKVGU0JXPHESEG"; //사이트에서 발급 받은 API KEY 
		String api_secret = "DL8UTJJ0JK0YXH8VX4OWBYS2CS9CHG8O"; //사이트에서 발급 받은 APISECRET KEY  
		Message coolsms = new Message(api_key, api_secret); 
		HashMap<String, String> params = new HashMap<String, String>(); 
		params.put("to", "01066220146"); 
		params.put("from", "01066220146"); //사전에 사이트에서 번호를 인증하고 등록하여야 함 params.put("type", "SMS"); params.put("text", "Test Message"); //메시지 내용 params.put("app_version", "test app 1.2"); try { JSONObject obj = (JSONObject) coolsms.send(params); System.out.println(obj.toString()); //전송 결과 출력 } catch (CoolsmsException e) { System.out.println(e.getMessage()); System.out.println(e.getCode()); }
		params.put("type", "SMS");
		params.put("text", "써치 까치고객님이 예약하신 상품가 등록되었습니다.써치까치를 이용해주셔서 감사합니다.");
		params.put("app_version", "test app 1.2"); // application name and version
		System.out.println("들어왔습니당. 가즈아");
		//보내는 구간
	    try {
	        JSONObject obj = (JSONObject) coolsms.send(params);
	        System.out.println(obj.toString());
	      } catch (CoolsmsException e) {
	        System.out.println(e.getMessage());
	        System.out.println(e.getCode());
	      }
		
		return null;
	}

}
