<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>약관</title>
    <link rel="stylesheet" href="../css/style.css"/>
    
    <script>
    	// JavaScript 시작
    	document.addEventListener('DOMContentLoaded', function(){
    		console.log('here1...')
    		
    		// 다음 버튼 클릭
    		const btnNext = document.getElementsByClassName('btnNext')[0];
    		const checks = document.querySelectorAll('input[type=checkbox]');
    		
    		btnNext.addEventListener('click', function(e){
    			e.preventDefault();
    			
    			if(!checks[0].checked){
    				alert('사이트 이용약관에 동의해주세요.');
    				return;
    			}
    			
    			if(!checks[1].checked){
    				alert('사이트 이용약관에 동의해주세요.');
    				return;
    			}
    			
    			// 회원가입 이동
    			location.href = '/jboard/user/register.do';
    		})
    	})
    </script>
    
</head>
<body>
    <div id="wrapper">
        <%@ include file="./_head.jsp" %>
        <main id="user">
            <section class="terms">
                <h2 class="tit">사이트 이용약관</h2>
                <table border="1">                    
                    <tr>
                        <td>
                            <textarea name="terms">${termsDTO.basic}약관내용</textarea>
                            <label><input type="checkbox" class="terms">&nbsp;동의합니다.</label>
                        </td>
                    </tr>
                </table>

                <h2 class="tit">개인정보 취급방침</h2>
                <table border="1">                    
                    <tr>
                        <td>
                            <textarea name="privacy">${termsDTO.privacy}약관내용</textarea>
                            <label><input type="checkbox" class="privacy">&nbsp;동의합니다.</label>
                        </td>
                    </tr>
                </table>
                
                <div>
                    <a href="/jboard/user/login.do" class="btn btnCancel">취소</a>
                    <a href="/jboard/user/register.do" class="btn btnNext">다음</a>
                </div>

            </section>
        </main>
        <%@ include file="./_tail.jsp" %>
    </div>    
</body>
</html>