<template>
<footer>
  <div class="footTop">
    <div class="footInner">
      <ul class="footMenu">
        <li><strong class="tit">에디패스</strong><a href="#" role="button">회사소개</a><a href="#" role="button">회원혜택 안내</a></li>
        <li><strong class="tit">고객센터</strong><a href="#" role="button">공지사항</a><a href="#" role="button">자주찾는질문</a><a href="#" role="button">예약확인</a></li>
        <li><strong class="tit">ESG</strong><a href="#" role="button">그린 앰버서더</a><a href="#" role="button">캠페인 기부</a></li>
      </ul>
      <div class="footAppDown">
        <h5>App 다운로드</h5>
        <span class="txt">제주패스 앱 설치하고 <br>더 편리하게 이용하세요.</span>
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
</footer>
</template>

<script>
export default {

}
</script>

<style scoped>
body, p, h1, h2, h3, h4, h5, h6, ul, ol, li, dl, dt, dd, table, th, td, form, fieldset, legend, input, textarea, button, select, div, figure, article, header, nav, footer, section, input, textarea, button, span, strong, em {
    margin: 0;
    padding: 0;
    color: #606060;
    font-family: Pretendard,-apple-system,BlinkMacSystemFont,Open Sans,Helvetica Neue,sans-serif;
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
    display: inline-block;
    padding: 45px 0 60px;
    font-size: 0;
    vertical-align: top;
}

ul, ol {
    list-style: none;
    display: block;
}

ul:after, ol:after {
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
    display: inline-block;
    width: 383px;
    height: 247px;
    padding: 43px 39px 0 39px;
    border: solid #EAEAEA;
    border-width: 0 1px;
    background: url(@/assets/footer/QRCodeImg.jpg) no-repeat 240px 15px;
    background-size: 130px;
}

footer .footTop .footAppDown h5 {
    display: block;
    margin-bottom: 12px;
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
    display: inline-block;
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

</style>