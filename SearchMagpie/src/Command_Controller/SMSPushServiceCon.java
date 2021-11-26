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
		//1�ð� ���� ->  �������� ������ �������°ſ��µ� ..�̰� �ð� üũ�ؼ� 
		String api_key = "NCSKVGU0JXPHESEG"; //����Ʈ���� �߱� ���� API KEY 
		String api_secret = "DL8UTJJ0JK0YXH8VX4OWBYS2CS9CHG8O"; //����Ʈ���� �߱� ���� APISECRET KEY  
		Message coolsms = new Message(api_key, api_secret); 
		HashMap<String, String> params = new HashMap<String, String>(); 
		params.put("to", "01066220146"); 
		params.put("from", "01066220146"); //������ ����Ʈ���� ��ȣ�� �����ϰ� ����Ͽ��� �� params.put("type", "SMS"); params.put("text", "Test Message"); //�޽��� ���� params.put("app_version", "test app 1.2"); try { JSONObject obj = (JSONObject) coolsms.send(params); System.out.println(obj.toString()); //���� ��� ��� } catch (CoolsmsException e) { System.out.println(e.getMessage()); System.out.println(e.getCode()); }
		params.put("type", "SMS");
		params.put("text", "��ġ ��ġ������ �����Ͻ� ��ǰ�� ��ϵǾ����ϴ�.��ġ��ġ�� �̿����ּż� �����մϴ�.");
		params.put("app_version", "test app 1.2"); // application name and version
		System.out.println("���Խ��ϴ�. �����");
		//������ ����
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
