<template>
  <!-- 메인의 서비스 이용 안내 파트입니다. -->
  <div class="mainCont">
    <h3 class="titDep2">서비스 이용안내</h3>
    <ul class="mainIcon">
      <li class="reservation">
        <a href="#"><span>예약안내</span></a>
      </li>
      <li class="insurance">
        <a href="#"><span>보험안내</span></a>
      </li>
      <li class="return">
        <a href="#"><span>렌트안내</span></a>
      </li>
      <li class="infomation">
        <a href="#"><span>이용안내</span></a>
      </li>
      <li class="cancellation">
        <a href="#"><span>결항안내</span></a>
      </li>
      <li class="refund">
        <a href="#"><span>취소/환불 안내</span></a>
      </li>
    </ul>

    <div class="mainNews">
      <div class="txt">
        <h4 class="titDep3">에디패스 뉴스레터 구독하기</h4>
        <p class="desc">매주 최신의 여행이야기를 받아보세요!</p>
      </div>
      <div class="email">
        <input
          type="text"
          placeholder="구독신청 이메일을 입력해주세요."
          subscriptionsinp=""
        />
        <button
          type="button"
          class="btnDefault btnL action"
          subscriptionsbtn=""
        >
          신청
        </button>
      </div>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
@font-face {
  font-family: "NanumSquareRound";
  src: url("https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_two@1.0/NanumSquareRound.woff")
    format("woff");
}

h3,
ul,
ol,
li,
input,
button,
div {
  margin: 0;
  padding: 0;
  color: #606060;
  font-family: Pretendard, -apple-system, BlinkMacSystemFont, Open Sans,
    Helvetica Neue, sans-serif;
  font-weight: 400;
  font-size: 10px;
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

.mainCont {
  margin-top: 104px;
}

.mainCont:first-child {
  margin-top: 54px;
}

.titDep2 {
  margin-top: 104px;
  text-align: center;
}

.titDep2 {
  margin-bottom: 32px;
  font-size: 2rem;
  line-height: 1.3;
  font-family: NanumSquareRound;
  font-weight: 900;
}

[class^="titDep"] {
  position: relative;
  color: #202020;
  line-height: 1;
  font-weight: 700;
}

h3 {
  display: block;
  font-size: 1.17em;
  margin-block-start: 1em;
  margin-block-end: 1em;
  margin-inline-start: 0px;
  margin-inline-end: 0px;
  font-weight: bold;
}

ul,
ol {
  list-style: none;
}

.mainCont .mainIcon {
  display: -webkit-box;
  display: -ms-flexbox;
  display: flex;
  -webkit-box-pack: center;
  -ms-flex-pack: center;
  justify-content: center;
  margin: 32px -34px 0;
}

.mainCont .mainIcon li {
  display: -webkit-box;
  display: -ms-flexbox;
  display: flex;
  position: relative;
  height: 141px;
  padding: 0 34px;
  -webkit-box-align: center;
  -ms-flex-align: center;
  align-items: center;
  -webkit-box-orient: vertical;
  -webkit-box-direction: normal;
  -ms-flex-direction: column;
  flex-direction: column;
}

li {
  display: list-item;
  text-align: -webkit-match-parent;
}

.mainCont .mainIcon li a {
  display: -webkit-box;
  display: -ms-flexbox;
  display: flex;
  -webkit-box-pack: center;
  -ms-flex-pack: center;
  justify-content: center;
  width: 96px;
  height: 96px;
  border: 1px solid #cde0ff;
  border-radius: 100%;
  -webkit-box-sizing: border-box;
  box-sizing: border-box;
  -webkit-box-shadow: 0 8px 12px 0 rgb(32 32 32 / 4%);
  box-shadow: 0 8px 12px 0 rgb(32 32 32 / 4%);
}

.mainCont .mainIcon li.insurance a:before {
  background-position: -32px 0;
}

.mainCont .mainIcon li a:before {
  content: "";
  display: block;
  margin: 32px auto;
  width: 32px;
  height: 32px;
  background: url(@/assets/spr_mainicon.png) no-repeat 0 0;
}

.mainCont .mainIcon li a span {
  position: absolute;
  top: 120px;
  text-align: center;
  color: #404040;
  font-size: 1.1rem;
  font-weight: 600;
  line-height: 1.56;
}

.mainCont .mainNews {
  display: -webkit-box;
  display: -ms-flexbox;
  display: flex;
  -webkit-box-pack: justify;
  -ms-flex-pack: justify;
  justify-content: space-around;
  position: relative;
  padding: 105px 40px 1vh;
}
.mainCont .mainNews {
  height: 250px;
  margin: 0%;
}

.mainCont .mainNews:before {
  content: "";
  display: block;
  position: absolute;
  top: 60px;
  left: 0;
  width: 100%;
  height: 140px;
  background: url(@/assets/bg_news.png) no-repeat;
}

.mainCont .mainNews .txt .titDep3 {
  position: relative;
  margin: 4px 0 11px;
}

.titDep3 {
  margin-bottom: 16px;
  font-size: 1.4rem;
  line-height: 1.4;
}
.titDep4 {
  display: block;
  position: absolute;
  top: -23px;
  left: 20px;
  margin-bottom: 16px;
  font-size: 0.9rem;
  font-weight: 200;
  line-height: 1.4;
  color: gray;
}
.mainCont .mainNews .txt .desc {
  position: relative;
  margin-top: -8px;
  color: gray;
  line-height: 1.44;
  font-size: 1rem;
}

.mainCont .mainNews .email {
  position: relative;
  margin: 5px 0 150px;
}

.mainCont .mainNews .email input[type="text"] {
  height: 56px;
  padding: 0 45px 0 15px;
}

input[type="text"] {
  display: inline-block;
  min-width: 100px;
  height: 48px;
  padding: 0 15px;
  color: #606060;
  font-size: 1rem;
  line-height: 48px;
  border-radius: 8px;
  border: 1px solid #eaeaea;
  background: #fff;
}

input:focus {
  outline: none !important;
  border: 1px solid #1d68dc;
}

.mainCont .mainNews .email .btnDefault.btnL.action {
  width: 5vw;
  margin-left: 4px;
}

.btnDefault.action {
  color: #fff;
  background: #569aff;
}

.btnL {
  min-width: 88px;
  height: 56px;
  padding: 0 24px;
  color: #63a1ff;
  font-size: 1rem;
  border-radius: 12px;
  line-height: 56px;
  background: #e6effe;
}

.btnDefault {
  overflow: hidden;
  position: relative;
  display: inline-block;
  font-weight: 600;
  text-align: center;
}
@media screen and (min-width: 1904px) {
  .mainCont .mainNews:before {
    left: 18%;
  }
  .mainCont .mainNews {
    justify-content: center;
  }
  .mainCont .mainNews .txt {
    margin: 0 5%;
  }
  .mainCont .mainNews .email {
    margin-bottom: 150px;
    padding: 0 5%;
  }
  .titDep4 {
    top: -23px;
    left: 100px;
  }
}
@media screen and (min-width: 360px) and (max-width: 768px) {
  .mainCont {
    height: outo;
    flex-direction: column;
  }

  .mainCont .mainNews {
    display: flex;
    flex-direction: column;
    height: 200px;
    padding: 30px 0 10px;
  }
  .mainCont .mainNews:before {
    top: 22px;
    width: 100%;
    height: 180px;
    background: url(@/assets/bg_news.png) no-repeat;
  }
  .mainCont .mainNews .email {
    margin-bottom: 42px;
    padding: 0 5%;
  }
  .titDep4 {
    display: none;
  }
}
</style>
