<template>
    <div>
        <!-- 기본정보 -->
        <div class="hotelName">
            <h3>기본정보</h3>
            <hr>
            <label class="hotelNameLabel">숙소명</label>
            <input type="text" class="hotelNameBox" :value="hotel.hotelName" readonly/>
        </div>

        <!-- 시설정보 -->
        <div class="hotelInfo">
            <h3>시설정보</h3>
            <hr>
            <label class="hotelInfoLabel">옵션</label>    
            <input type="text" class="hotelInfobox" :value="hotel.hotelInfo" readonly/>
        </div>
        
        <!-- 위치정보 -->
        <div class="hotelAddress">
            <h3>위치정보</h3>
            <hr>
            <div class="adApi">
                <label>우편번호</label>
                <input type="text" id="postcode" :value="hotel.postcode" readonly/><br>
                <label>주소</label>
                <input type="text" id="address" :value="hotel.totalAddress" readonly/>
            </div>
        </div>
        
        <!-- 이미지 -->
        <div class="hotelImg">
            <h3>이미지</h3>
            <hr>
            <div>
                <v-img width="100px" height="100px" :src="require(`@/assets/hotelImg/${hotel.hotelImgPath1}`)"/>
                <v-img width="100px" height="100px" :src="require(`@/assets/hotelImg/${hotel.hotelImgPath2}`)"/>
                <v-img width="100px" height="100px" :src="require(`@/assets/hotelImg/${hotel.hotelImgPath3}`)"/>
                <v-img width="100px" height="100px" :src="require(`@/assets/hotelImg/${hotel.hotelImgPath4}`)"/>
                <v-img width="100px" height="100px" :src="require(`@/assets/hotelImg/${hotel.hotelImgPath5}`)"/>
                <v-img width="100px" height="100px" :src="require(`@/assets/hotelImg/${hotel.hotelImgPath6}`)"/>
                <v-img width="100px" height="100px" :src="require(`@/assets/hotelImg/${hotel.hotelImgPath7}`)"/>
                <v-img width="100px" height="100px" :src="require(`@/assets/hotelImg/${hotel.hotelImgPath8}`)"/>
                <v-img width="100px" height="100px" :src="require(`@/assets/hotelImg/${hotel.hotelImgPath9}`)"/>
            </div>
        </div>



    </div>
</template>

<script>
export default {
    name: 'HotelRead',
    props: {
        hotel: {
            type: Object,
            require: true
        }
    }
}
</script>

<style scoped>
div {
  -webkit-user-select:none;
  -moz-user-select:none;
  -ms-user-select:none;
  user-select:none
}
a {
    text-decoration: none;
}
h3 {
    margin: 10px;
}
.hotelName {
    margin: 50px 50px 10px 50px;
}
.hotelNameP {
    position: absolute;
    top: 5%;
    left: 88%;
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
    font-size: 14px;
    font-weight: bold;
    outline: none;
}
.hotelInfo {
    margin: 30px 50px 0px 50px;
}
.hotelInfoLabel {
    font-size: 14px;
    margin-left: 50px;
}
.hotelInfobox, .hotelInfobox:focus {
    width: 400px;
    padding: 5px 8px;
    margin: 30px;
    font-size: 14px;
    font-weight: bold;
    outline: none;
}
.hotelAddress {
    margin: 30px 50px 30px 50px;
}
.adApi {
    padding: 0px 0px 0px 50px;
    font-size: 14px;
}
input[id="postcode"] {
    width: 100px;
    padding: 5px 8px;
    margin: 30px 0px 0px 35px;
    font-size: 14px;
    font-weight: bold;
    outline: none;
}
input[id="address"] {
    width: 700px;
    padding: 5px 8px;
    margin: 0px 0px 0px 35px;
    font-size: 14px;
    font-weight: bold;
    outline: none;
}
.hotelImg {
    margin: 50px 50px 10px 50px;
}
#files {
    margin: 50px;
}

</style>