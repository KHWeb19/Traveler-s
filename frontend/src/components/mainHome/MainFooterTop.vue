<template>
    <footer-top>
        <div class="footTop">
            <div class="footInner">
                <ul class="footMenu">
                    <li class="MenuLi"><strong class="tit">에디패스</strong><a href="#" role="button">회사소개</a><a href="#"
                            role="button">회원혜택 안내</a></li>
                    <li class="MenuLi"><strong class="tit">고객센터</strong><a href="#" role="button">공지사항</a><a href="#"
                            role="button">자주찾는질문</a><a href="#" role="button">예약확인</a></li>
                    <li class="MenuLi"><strong class="tit">ESG</strong><a href="#" role="button">그린 앰버서더</a><a href="#"
                            role="button">캠페인 기부</a></li>
                </ul>
                <div class="footAppDown">
                    <h5>App 다운로드</h5>
                    <span class="txt">제주패스 앱 설치하고 </span>
                    <span class="txt"> 더 편리하게 이용하세요.</span>
                    <ul class="appLink">
                        <li><button type="button" class="google" onclick="location.href='#';">구글플레이</button></li>
                        <li><button type="button" class="ios" onclick="location.href='#';">앱스토어</button></li>
                    </ul>
                </div>
                <div class="footCenter">
                    <h5>전화예약 / 고객상담</h5>
                    <span class="txt">이용에 궁금하신 점이 <br>있으신가요?</span>
                    <div class="callInfo">
                        <p class="callNum">1544-0445</p>
                        <ul class="callTime">
                            <li><span class="tit">평일</span>09:00 ~ 18:00</li>
                            <li><span class="tit">점심시간</span>12:00 ~ 13:00</li>
                        </ul>
                    </div>
                    <div class="snsList">
                        <a href="#">
                            <v-img src="@/assets/footer/Facebook.png" width="30px"></v-img>
                        </a>
                        <a href="#">
                            <v-img src="@/assets/footer/Instagram.png" width="30px"></v-img>
                        </a>
                        <a href="#">
                            <v-img src="@/assets/footer/KakaoTalk.png" width="30px"></v-img>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </footer-top>
</template>

<script>
export default {

}
</script>

<style scoped>
body,
p,
h1,
h2,
h3,
h4,
h5,
h6,
ul,
ol,
li,
dl,
dt,
dd,
table,
th,
td,
form,
fieldset,
legend,
input,
textarea,
button,
select,
div,
figure,
article,
header,
nav,
footer,
section,
input,
textarea,
button,
span,
strong,
em {
    margin: 0;
    padding: 0;
    color: #606060;
    font-family: Pretendard, -apple-system, BlinkMacSystemFont, Open Sans, Helvetica Neue, sans-serif;
    font-weight: 400;
    font-size: 15px;
    line-height: 1.5;
    letter-spacing: -0.01em;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
    word-break: keep-all;
    word-wrap: break-word;
    white-space: normal;
}

div {
    display: block;
}

footer {
    position: relative;
    height: 250px;
    border-top: 1px solid #EAEAEA;
    text-align: center;
    z-index: 1;
}

footer .footTop {
    background: #fff;
    font-size: 0;
    border-top: 1px solid #EAEAEA;
}

footer .footInner {
    position: relative;
    width: 1280px;
    margin: 0 auto;
    padding: 0 72px;
    text-align: left;
    z-index: 2;
    font-size: 0;
}

footer .footTop .footMenu {
    display: inline-flex;
    padding: 45px 0 60px;
    font-size: 0;
    vertical-align: top;
}

ul,
ol {
    list-style: none;
    display: block;
}

ul:after,
ol:after {
    content: '';
    display: block;
    clear: both;
}

footer .footTop .footMenu>li {
    display: inline-block;
    width: 125px;
    vertical-align: top;
}

li {
    display: list-item;
    text-align: -webkit-match-parent;
}

footer .footTop .footMenu>li .tit {
    display: block;
    margin-bottom: 14px;
    color: #202020;
    font-size: 1.2rem;
    font-weight: 700;
    line-height: 21px;
}

footer .footTop .footMenu>li>a {
    display: block;
    line-height: 35px;
}

a {
    color: inherit;
    text-decoration: none;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
}

footer .footTop .footAppDown {
    display: inline-flex;
    width: 383px;
    height: 247px;
    padding: 43px 39px 0 39px;
    border: solid #EAEAEA;
    border-width: 0 1px;
    background: url(@/assets/footer/QRCodeImg.jpg) no-repeat 240px 15px;
    background-size: 130px;
    flex-direction: column;
}

footer .footTop .footAppDown h5 {
    display: block;
    margin: 0 0 12px;
    color: #202020;
    font-size: 1.2rem;
    font-weight: 700;
    line-height: 21px;
}

footer .footTop .footAppDown .txt {
    color: gray;
    font-size: 0.9rem;
}

footer .footTop .footAppDown .appLink {
    font-size: 0;
    margin: 32px -4px 0;
}

footer .footTop .footAppDown .appLink>li {
    display: inline-block;
    width: 50%;
    padding: 0 4px;
}

footer .footTop .footAppDown .appLink>li button {
    position: relative;
    display: block;
    width: 100%;
    color: #202020;
    font-size: 0.8rem;
    font-weight: 600;
    line-height: 38px;
    text-align: center;
    border: 1px solid #DADADA;
    border-radius: 8px;
}

footer .footTop .footAppDown .appLink>li button:before {
    display: inline-flex;
    height: 24px;
    margin: 0 2px 2px 0;
    vertical-align: middle;
}

footer .footTop .footCenter {
    display: inline-block;
    width: 375px;
    height: 247px;
    padding: 43px 39px 0 39px;
    vertical-align: top;
}

footer .footTop .footCenter h5 {
    display: block;
    margin-bottom: 16px;
    color: #202020;
    font-size: 1.2rem;
    font-weight: 700;
    line-height: 21px;
}

footer .footTop .footCenter .txt {
    color: gray;
    font-size: 0.9rem;
}

footer .footTop .footCenter .callInfo {
    position: absolute;
    top: 38px;
    right: 72px;
}

footer .footTop .footCenter .callInfo .callNum {
    color: #202020;
    font-size: 1.5rem;
    font-weight: 700;
    line-height: 29px;
}

footer .footTop .footCenter .callInfo .callTime {
    margin-top: 14px;
}

footer .footTop .footCenter .callInfo .callTime>li {
    font-size: 0.8rem;
}

footer .footTop .footCenter .callInfo .callTime>li .tit {
    display: inline-block;
    width: 70px;
    font-size: 0.9rem;
}

footer .footTop .footCenter .snsList {
    margin: 24px 0 0 0px;
}

footer .footTop .footCenter .snsList>a {
    position: relative;
    display: inline-block;
    width: 48px;
    height: 48px;
}

footer .footTop .footCenter .snsList>a:after {
    content: '';
    display: block;
    position: absolute;
    top: 50%;
    left: 50%;
    width: 32px;
    height: 32px;
    margin-top: -16px;
    background: -52px -132px;
}

@media screen and (min-width: 1024px) and (max-width: 1240px) {

    /* 일반모니터 */
    footer .footTop .footMenu {
        width: 39vw;
    }

    footer .footInner {
        padding: 0px 0px 0px 2vw;
    }

    footer .footTop .footMenu>li {
        width: 13vw;
    }

    footer .footTop .footMenu>li .tit {
        margin-bottom: 12px;
        font-size: 1.1rem;
        line-height: 20px;
    }

    a {
        margin-bottom: 10px;
        font-size: 0.9rem;
        line-height: 17px;
        height: 19px;
    }

    footer .footTop .footAppDown {
        width: 29.5714vw;
        padding: 43px 3vw 0px;
        border-width: 0 1px;
        background: url(@/assets/footer/QRCodeImg.jpg) no-repeat 17.5vw 2vh;
        background-size: 115px;
    }

    footer .footTop .footAppDown h5 {
        margin-bottom: 12px;
        font-size: 1.1rem;
        line-height: 18px;
    }

    footer .footTop .footAppDown .txt {
        font-size: 0.8rem;
    }

    footer .footTop .footAppDown .appLink {
        margin: 16px -2px 0;
    }

    footer .footTop .footAppDown .appLink>li {
        display: inline-block;
        width: 50%;
        padding: 0 4px;
    }

    footer .footTop .footAppDown .appLink>li button {
        width: 90%;
        font-size: 0.8rem;
        text-align: center;
    }

    footer .footTop .footCenter {
        /* 오른쪽부분 글귀 */
        width: 27vw;
        padding: 41px 2vw 0px;
        vertical-align: top;
    }

    footer .footTop .footCenter h5 {
        /* 타이틀 */
        margin-bottom: 16px;
        font-size: 1.1rem;
        line-height: 19px;
    }

    footer .footTop .footCenter .txt {
        /*서브타이틀*/
        font-size: 0.75rem;
    }

    footer .footTop .footCenter .callInfo {
        /* 전화번호위치 */
        position: absolute;
        top: 80px;
        left: 85vw;
    }

    footer .footTop .footCenter .callInfo .callNum {
        /* 전화번호 타이틀*/
        font-size: 1.3rem;
        line-height: 23px;
    }

    footer .footTop .footCenter .callInfo .callTime>li {
        /* 전화번호 서브타이틀*/
        font-size: 0.8rem;
    }

    footer .footTop .footCenter .callInfo .callTime>li .tit {
        /* 전화번호 서드타이틀 */
        display: inline-block;
        width: 54px;
        font-size: 0.85rem;
    }

    footer .footTop .footCenter .snsList {
        /* */
        margin: 15px 0 0 0px;
    }

    footer .footTop .footCenter .snsList>a {
        /* sns이미지 크기 */
        width: 4vw;
        height: 4vh;
    }
}

@media screen and (min-width: 768px) and (max-width: 1024px) {

    /* 테블릿 */
    footer .footTop .footMenu {
        width: 36vw;
    }

    footer .footInner {
        padding: 0px 0px 0px 1vw;
    }

    footer .footTop .footMenu>li {
        width: 11.5714vw;
    }

    footer .footTop .footMenu>li .tit {
        margin-bottom: 12px;
        font-size: 1rem;
        line-height: 18px;
    }

    a {
        margin-bottom: 10px;
        font-size: 0.80rem;
        line-height: 15px;
        height: 17px;
    }

    footer .footTop .footAppDown {
        width: 29.5714vw;
        padding: 43px 1.2vw 0px;
        border-width: 0 1px;
        background: url(@/assets/footer/QRCodeImg.jpg) no-repeat 17vw 2vh;
        background-size: 115px;
    }

    footer .footTop .footAppDown h5 {
        margin-bottom: 12px;
        font-size: 1rem;
        line-height: 18px;
    }

    footer .footTop .footAppDown .txt {
        font-size: 0.8rem;
    }

    footer .footTop .footAppDown .appLink {
        margin: 16px;
    }

    footer .footTop .footAppDown .appLink>li {
        display: inline-block;
        width: 50%;
        padding: 0 4px;
    }

    footer .footTop .footAppDown .appLink>li button {
        width: 90%;
        font-size: 0.7rem;
        line-height: 28px;
        text-align: center;
    }

    footer .footTop .footCenter {
        /* 오른쪽부분 글귀 */
        width: 270px;
        padding: 41px 0.6428vw 0px;
        vertical-align: top;
    }

    footer .footTop .footCenter h5 {
        /* 타이틀 */
        margin-bottom: 16px;
        font-size: 1rem;
        line-height: 19px;
    }

    footer .footTop .footCenter .txt {
        /*서브타이틀*/
        font-size: 0.7rem;
    }

    footer .footTop .footCenter .callInfo {
        /* 전화번호위치 */
        position: absolute;
        top: 80px;
        left: 82vw;
    }

    footer .footTop .footCenter .callInfo .callNum {
        /* 전화번호 타이틀*/
        font-size: 1.3rem;
        line-height: 23px;
    }

    footer .footTop .footCenter .callInfo .callTime>li {
        /* 전화번호 서브타이틀*/
        font-size: 0.6rem;
    }

    footer .footTop .footCenter .callInfo .callTime>li .tit {
        /* 전화번호 서드타이틀 */
        display: inline-block;
        width: 50px;
        font-size: 0.7rem;
    }

    footer .footTop .footCenter .snsList {
        /* */
        margin: 15px 0 0 0px;
    }

    footer .footTop .footCenter .snsList>a {
        /* sns이미지 크기 */
        width: 35px;
        height: 35px;
    }
}

@media screen and (min-width: 360px) and (max-width: 768px) {

    /*스마트폰 */
    footer {
        height: outo;
        flex-direction: column;
    }

    footer .footInner {
        padding: 0px 0px 0px 2vw;
    }

    footer .footTop .footMenu {
        /*푸터 왼쪽 */
        border-top: solid #EAEAEA;
        border-width: 1px 0 0 0;
        width: 98vw;
        height: 200px;
        padding: 4vh 2vw 2vh;
        display: flex;
    }

    footer .footTop .footMenu>li {
        width: 27vw;
        margin: 0px 0px 0px 4vw;
    }

    footer .footTop .footMenu>li .tit {
        margin-bottom: 12px;
        font-size: 1.3rem;
        line-height: 19px;
    }

    a {
        margin-bottom: 10px;
        font-size: 0.9rem;
        line-height: 18px;
        height: 19px;
    }

    footer .footTop .footAppDown {
        /*푸터중앙 */
        display: inline-block;
        width: 98vw;
        height: 200px;
        border-top: solid #EAEAEA;
        border-width: 1px 0 0 0;
        background: url(@/assets/footer/QRCodeImg.jpg) no-repeat 50vw 0vh;
        background-size: 140px;
        padding: 3vh 2vw 2vh;
        margin-right: 0%;
        display: flex;
        flex-direction: column;
    }

    footer .footTop .footAppDown .txt br {
        line-height: 50%;
    }

    footer .footTop .footAppDown h5 {
        margin: 0 0 1.5vh 13vw;
        width: 200px;
        line-height: 21px;
    }

    footer .footTop .footAppDown .txt {
        font-size: 0.9rem;
        padding-left: 12vw;

    }

    footer .footTop .footAppDown {
        font-size: 0.9rem;
    }

    footer .footTop .footAppDown .appLink {
        margin: 3vh 0 0 10vw;
    }

    footer .footTop .footAppDown .appLink>li {
        display: inline-block;
        width: 40%;
        padding: 0 4px;
    }

    footer .footTop .footAppDown .appLink>li button {
        display: block;
        width: 85%;
        font-size: 0.8rem;
        line-height: 38px;
    }


    footer .footTop .footCenter {
        /* 푸터 오른쪽 */
        border-top: solid #EAEAEA;
        border-bottom: solid #EAEAEA;
        border-width: 1px 0 1px 0;
        width: 98vw;
        padding: 2vh 13vw 0px;
        vertical-align: top;
        height: 200px;
        display: flex;
        flex-direction: column;
    }

    footer .footTop .footCenter .callInfo {
        position: absolute;
        top: 42.5vh;
        left: 55vw;
    }


}
</style>