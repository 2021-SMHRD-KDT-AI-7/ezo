<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang = "ko">
    <head>
        <meta charset="UTF-8">
        <title>써치까치 회원정보 수정</title>
        <link rel="stylesheet" href="./css/edit_info.css">

        <!-- Bootstrap -->
        <!-- fonts -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
        <!-- font awesome -->
        <link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        
    </head>
    <body class="join" style="background: transparent;">
        <!-- header -->
        <div id="header">
        <h2>회원정보 수정</h2>
        </div>

        <!-- wrapper -->
        <div id="wrapper">

		<form action="updateMemberServiceCon.do" method="post">
            <!-- content-->
            <div id="content">

                <!-- NAME 0 -->
                <div>
                    <h3 class="join_title"><label for="name">이름</label></h3>
                    <span class="box int_name">
                        <input type="text" id="name" name="m_name" class="int" maxlength="20">
                    </span>
                    <span class="error_next_box"></span>
                </div>

                <!-- oldPW 1 -->
                <div>
                    <h3 class="join_title"><label for="oldPw">기존 비밀번호</label></h3>
                    <span class="box int_old_pass">
                        <input type="text" id="oldPw" class="int" maxlength="20">
                        <span id="alertTxt1">불일치</span>
                    </span>
                    <span class="error_next_box"></span>
                </div>

                <!-- PW1 2 -->
                <div>
                    <h3 class="join_title"><label for="pswd1">새로운 비밀번호</label></h3>
                    <span class="box int_pass">
                        <input type="text" id="pswd1" name="m_pw" class="int" maxlength="20">
                        <span id="alertTxt">사용불가</span>
                        <img src="./images/m_icon_pass.png" id="pswd1_img1" class="pswdImg">
                    </span>
                    <span class="error_next_box"></span>
                </div>

                <!-- PW2 3 -->
                <div>
                    <h3 class="join_title"><label for="pswd2">비밀번호 재확인</label></h3>
                    <span class="box int_pass_check">
                        <input type="text" id="pswd2" class="int" maxlength="20">
                        <img src="./images/m_icon_check_disable.png" id="pswd2_img1" class="pswdImg">
                    </span>
                    <span class="error_next_box"></span>
                </div>

                <!-- NICKNAME 4 -->
                <div>
                    <h3 class="join_title"><label for="nickName">닉네임</label></h3>
                    <span class="box int_nickName">
                        <input type="text" id="nickName" name="m_nickname" class="int" maxlength="20">
                    </span>
                    <span class="error_next_box"></span>
                </div>

                <!-- EMAIL 5 -->
                <div>
                    <h3 class="join_title"><label for="email">본인확인 이메일<span class="optional">(선택)</span></label></h3>
                    <span class="box int_email">
                        <input type="text" id="email" name="m_email" class="int" maxlength="100" placeholder="선택입력">
                    </span>
                    <span class="error_next_box">이메일 주소를 다시 확인해주세요.</span>    
                </div>

                <!-- MOBILE 6 -->
                <div>
                    <h3 class="join_title"><label for="phoneNo">휴대전화</label></h3>
                    <span class="box int_mobile">
                        <input type="tel" id="mobile" name="m_phone" class="int" maxlength="16" placeholder="- 빼고 숫자만 입력">
                    </span>
                    <span class="error_next_box"></span>    
                </div>

                <!-- aggrement -->
                <!-- <br>
                <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" id="aggrement" required>
                    <label class="custom-control-label" for="aggrement" style="font-family: 'Jua';" style="font-weight: bolder;">개인정보 수집 및 이용에 동의합니다.</label>
                </div><br> -->
                <!-- JOIN BTN-->
                <div class="btn_area">
                    <button type="submit" class="color" id="btnJoin">
                        <span>수정완료 </span>
                    </button>
                </div>
            </div> 
            <!-- content-->
		</form>
        </div> 
        <!-- wrapper -->
    <script src="./js/edit_info.js"></script>
    </body>
</html>