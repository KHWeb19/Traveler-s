<template>
    <form @submit.prevent="onSubmit">

    <!-- 기본정보 -->
    <div class="hotelName">
        <h3>기본정보</h3>
        <p class="hotelNameP">*은 필수 입력사항입니다.</p>
        <hr>
        <label class="hotelNameLabel">* 숙소명</label>
        <input type="text" class="hotelNameBox" v-model="hotelName" placeholder="숙소명을 입력해주세요."/>
    </div>
    
    <!-- 시설정보 -->
    <div class="hotelInfo">
        <h3>시설정보</h3>
        <hr>
        <div class="hotelInfobox">
        <label>
            <input type="checkbox" name="hotelinfo" v-model="hotelInfo">오션뷰
        </label>
        <label>
            <input type="checkbox" name="hotelinfo" v-model="hotelInfo">테라스
        </label>
        <label>
            <input type="checkbox" name="hotelinfo" v-model="hotelInfo">수영장
        </label>
        <label>
            <input type="checkbox" name="hotelinfo" v-model="hotelInfo">전기차충전
        </label>
        <label>
            <input type="checkbox" name="hotelinfo" v-model="hotelInfo">공항근처
        </label>
        <label>
            <input type="checkbox" name="hotelinfo" v-model="hotelInfo">골프장
        </label>
        <label>
            <input type="checkbox" name="hotelinfo" v-model="hotelInfo">무료주차
        </label>
        <label>
            <input type="checkbox" name="hotelinfo" v-model="hotelInfo">바베큐그릴
        </label>
        <label>
            <input type="checkbox" name="hotelinfo" v-model="hotelInfo">반려동물
        </label>
        <label>
            <input type="checkbox" name="hotelinfo" v-model="hotelInfo">온천
        </label>
        </div>
    </div>

    <!-- 위치정보 -->
    <div class="hotelAddress">
        <h3>위치정보</h3>
        <hr>
        <div class="adApi">
            <input type="text" id="sample6_postcode" placeholder="우편번호">
            <input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
            <input type="text" id="sample6_address" placeholder="주소"><br>
            <input type="text" id="sample6_detailAddress" placeholder="상세주소">
            <input type="text" id="sample6_extraAddress" placeholder="참고항목">
        </div>
    </div>

    <!-- 이미지 -->
    <div class="hotelImg">
        <h3>이미지</h3>
        <hr>
        <p class="hotelImgLabel">* 숙소이미지</p>
    </div>

    <div class="btn">
    <button type="submit">저장하기</button>
        <router-link :to="{ name: '' }">
            취소
        </router-link>
    </div>

</form>
</template>

<script>
export default {
    name: 'HotelRegisterForm',
}
</script>

<style>
h3 {
    margin: 10px;
}
.hotelName {
    margin: 50px 50px 10px 50px;
}
.hotelNameP {
    position: absolute;
    top: 7%;
    left: 87%;
    font-size: 12px;
}
.hotelNameLabel {
    font-size: 14px;
    margin-left: 50px;
}
.hotelNameBox, .hotelNameBox:focus {
    width: 400px;
    padding: 5px 8px;
    margin: 30px;
    font-size: 13px;
    border-radius: 2pt;
    box-shadow: 0 0 0 1pt grey;
    outline: none;
    transition: .1s;
}
.hotelInfo {
    margin: 30px 50px 0px 50px;
}
.hotelInfobox {
    padding: 50px 0px 0px 0px;
    text-align: center;
    word-spacing: 50px;
    letter-spacing: 1px;
    font-size: 14px;
}
input[name="hotelinfo"] {
    position: relative;
    right: 5px;
    top: 1px;
}
.hotelAddress {
    margin: 50px 50px 10px 50px;
}
.adApi {
    padding: 50px 0px 0px 50px;
    font-size: 14px;
    line-height: 50px;
}
input[id="sample6_postcode"] {
    width: 200px;
    height: 30px;
    padding: 0px 10px 0px 10px;
    margin-right: 20px;
    font-size: 13px;
    border-radius: 2pt;
    box-shadow: 0 0 0 1pt grey;
    outline: none;
}
input[id="sample6_address"] {
    width: 700px;
    height: 30px;
    padding: 0px 10px;
    font-size: 13px;
    border-radius: 2pt;
    box-shadow: 0 0 0 1pt grey;
    outline: none;
}
input[id="sample6_detailAddress"] {
    width: 300px;
    height: 30px;
    padding: 0px 10px;
    font-size: 13px;
    border-radius: 2pt;
    box-shadow: 0 0 0 1pt grey;
    outline: none;
}
input[id="sample6_extraAddress"] {
    width: 300px;
    height: 30px;
    padding: 0px 10px;
    margin-left: 20px;
    font-size: 13px;
    border-radius: 2pt;
    box-shadow: 0 0 0 1pt grey;
    outline: none;
}
.hotelImg {
    margin: 50px 50px 100px 50px;
}
.hotelImgLabel  {
    font-size: 14px;
    position: relative;
    left: 50px;
    top: 30px;
}
.btn {
    text-align: center;
    word-spacing: 10px;
}
</style>