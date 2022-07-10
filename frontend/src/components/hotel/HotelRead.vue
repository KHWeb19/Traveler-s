<template>
    <v-container class="board-list">
        <!-- 기본정보 -->
        <div class="hotelName">

            <table style="width: 100%">
                  <colgroup>
                    <col class="label">
                    <col class="content">
                </colgroup>
                <tr>
                    <td colspan="2">
                        <h3>기본정보</h3>
                    </td>
                </tr>

                <tr>
                    <td align="center" id="title2">숙소명</td>
                    <td class="content">
                        <input type="text" class="hotelNameBox" :value="bmHotel.hotelName" readonly/>
                    </td>                    
                </tr>
                
                <tr>
                    <td align="center" id="title2">소개글</td>
                    <td class="content">
                        <input type="text" class="hotelNameBox" :value="bmHotel.hotelIntro" readonly/>
                    </td>                    
                </tr>
            </table>

        </div>

        <!-- 시설정보 -->
        <div class="hotelInfo">

            <table style="width: 100%">
                  <colgroup>
                    <col class="label">
                    <col class="content">
                </colgroup>
                <tr>
                    <td colspan="2">
                        <h3>시설정보</h3>
                    </td>
                </tr>

                <tr>
                    <td align="center" id="title2">옵션</td>
                    <td class="content">
                        <input type="text" class="hotelInfobox" style="width: 100%" :value="bmHotel.hotelInfo" readonly/>
                        
                    </td>
                </tr>
            </table>

        </div>
        
        <!-- 위치정보 -->
        <div class="hotelAddress">
            <table style="width: 100%">
                  <colgroup>
                    <col class="label">
                    <col class="content">
                </colgroup>
                <tr>
                    <td colspan="2">
                        <h3>위치정보</h3>
                    </td>
                </tr>

                <tr>
                    <td align="center" id="title2">우편번호</td>
                    <td class="content">
                        <input type="text" class="hotelInfobox" style="width: 100%" :value="bmHotel.postcode" readonly/>
                        
                    </td>
                </tr>
                <tr>
                    <td align="center" id="title2">주소</td>
                    <td class="content">
                        <input type="text" class="hotelInfobox" style="width: 100%" :value="bmHotel.totalAddress" readonly/>
                        
                    </td>
                </tr>                
            </table>

        </div>
        
        <!-- 이미지 -->
        <div class="hotelImg">

            <table style="width: 100%">
                  <colgroup>
                    <col class="label">
                    <col class="content">
                </colgroup>
                <tr>
                    <td colspan="2">
                        <h3>이미지</h3>
                    </td>
                </tr>
                <tr>
                    <td>
                        <v-container>
                            <v-row>
                            <v-img width="100px" height="100px" v-for="(item, index) in bmHotel.hotelImages" :key=index
                            :src="require(`@/assets/hotelImg/${item}`)"></v-img>
                            </v-row>
                        </v-container>
                    </td>
                </tr>
            </table>

        </div>
    </v-container>
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
/* 컬럼의 너비 */
.label {width: 20%;}
.content { /* 자동으로 맞춰집니다 */ }

h3 {
    margin: 10px;
    color:#18225c;
    padding: 10px 0px 10px 2px;
}
#title2 {
    color:#6e91b3;
    background-color: #e4f1f8;
    font-weight: bold;
    width: 95px;
}


td {
  color: rgb(34, 34, 34);
  font-size:14px;
  height: 30px;
}

div {
  -webkit-user-select:none;
  -moz-user-select:none;
  -ms-user-select:none;
  user-select:none
}
a {
    text-decoration: none;
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
    outline: none;
}
input[id="address"] {
    width: 700px;
    padding: 5px 8px;
    margin: 0px 0px 0px 35px;
    font-size: 14px;
    outline: none;
}
.hotelImg {
    margin: 50px 50px 10px 50px;
}
#files {
    margin: 50px;
}

</style>