<template>
    <div>
        <!-- 기본정보 -->
        <div class="hotelName">
            <h3>기본정보</h3>
            <hr>
            <label class="hotelNameLabel">숙소명</label>
            <input type="text" class="hotelNameBox" :value="bmHotel.hotelName" readonly/>
        </div>

        <!-- 시설정보 -->
        <div class="hotelInfo">
            <h3>시설정보</h3>
            <hr>
            <label class="hotelInfoLabel">옵션</label>    
            <input type="text" class="hotelInfobox" :value="bmHotel.hotelInfo" readonly/>
        </div>
        
        <!-- 위치정보 -->
        <div class="hotelAddress">
            <h3>위치정보</h3>
            <hr>
            <div class="adApi">
                <label>우편번호</label>
                <input type="text" id="postcode" :value="bmHotel.postcode" readonly/><br>
                <label>주소</label>
                <input type="text" id="address" :value="bmHotel.totalAddress" readonly/>
            </div>
        </div>
        
        <!-- 이미지 -->
        <div class="hotelImg">
            <h3>이미지</h3>
            <hr>
            <div>
                <v-container>
                    <v-img v-for="(item, index) in bmHotel.hotelImages" :key=index
                    :src="require(`@/assets/hotelImg/${item}`)"></v-img>
                </v-container>
            </div>
        </div>



    </div>
</template>

<script>
export default {
    name: 'HotelRead',
    props: {
        bmHotel: {
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