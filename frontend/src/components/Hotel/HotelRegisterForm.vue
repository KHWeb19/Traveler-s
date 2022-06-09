<template>
<form @submit.prevent="onSubmit">

    <div class="hotelName">
        <h3>기본정보</h3>
        <p class="hotelNameP">*은 필수 입력사항입니다.</p>
    </div>
    <label class="hotelNameLabel">* 숙소명</label>
    <input type="text" class="hotelNameBox" placeholder="숙소명을 입력해주세요."/>

    <div class="hotelInfo">
        <h3>시설정보</h3>
    </div>
    <div class="hotelInfobox">
    <input type="checkbox" name="nb[]" value="01">
    <label>오션뷰</label>
    <input type="checkbox" name="nb[]" value="01">
    <label>테라스</label>
    <input type="checkbox" name="nb[]" value="01">
    <label class="hotelInfoLabel">수영장</label>
    <input type="checkbox" name="nb[]" value="01">
    <label class="hotelInfoLabel">전기차충전</label>
    <input type="checkbox" name="nb[]" value="01">
    <label class="hotelInfoLabel">공항근처</label>
    <input type="checkbox" name="nb[]" value="01">
    <label class="hotelInfoLabel">골프장</label>
    <input type="checkbox" name="nb[]" value="01">
    <label class="hotelInfoLabel">무료주차</label>
    <input type="checkbox" name="nb[]" value="01">
    <label class="hotelInfoLabel">바베큐그릴</label>
    <input type="checkbox" name="nb[]" value="01">
    <label class="hotelInfoLabel">반려동물</label>
    <input type="checkbox" name="nb[]" value="01">
    <label class="hotelInfoLabel">온천</label>
    </div>

    <div class="hotelAddress">
        <h3>위치정보</h3>
    </div>

    <div class="hotelImg">
        <h3>이미지</h3>
    </div>

</form>
</template>

<script>
export default {
    name: 'HotelRegisterForm',
}
</script>

<style>
.hotelName {
    margin: 50px 50px 10px 50px;
    border-bottom: 1px solid #233;
}
.hotelNameP {
    position: absolute;
    top: 7%;
    left: 87%;
    font-size: 12px;
}
.hotelNameLabel {
    font-size: 14px;
    margin-left: 100px;
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
    margin: 0px 50px 10px 50px;
    border-bottom: 1px solid #233;
}
.hotelInfobox {
    margin: 30px 10px 0px 50px;
}
.hotelInfoLabel {
    font-size: 13px;
}
.hotelAddress {
    margin: 150px 50px 10px 50px;
    border-bottom: 1px solid #233;
}
.hotelImg {
    margin: 250px 50px 10px 50px;
    border-bottom: 1px solid #233;
}
h3 {
    margin: 10px;
}

</style>