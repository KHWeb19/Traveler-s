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
            <input type="checkbox" name="hotelinfo" v-model="hotelInfo" value="오션뷰">오션뷰
        </label>
        <label>
            <input type="checkbox" name="hotelinfo" v-model="hotelInfo" value="테라스">테라스
        </label>
        <label>
            <input type="checkbox" name="hotelinfo" v-model="hotelInfo" value="수영장">수영장
        </label>
        <label>
            <input type="checkbox" name="hotelinfo" v-model="hotelInfo" value="전기차충전">전기차충전
        </label>
        <label>
            <input type="checkbox" name="hotelinfo" v-model="hotelInfo" value="공항근처">공항근처
        </label>
        <label>
            <input type="checkbox" name="hotelinfo" v-model="hotelInfo" value="골프장">골프장
        </label>
        <label>
            <input type="checkbox" name="hotelinfo" v-model="hotelInfo" value="무료주차">무료주차
        </label>
        <label>
            <input type="checkbox" name="hotelinfo" v-model="hotelInfo" value="바베큐그릴">바베큐그릴
        </label>
        <label>
            <input type="checkbox" name="hotelinfo" v-model="hotelInfo" value="반려동물">반려동물
        </label>
        <label>
            <input type="checkbox" name="hotelinfo" v-model="hotelInfo" value="온천">온천
        </label>
        </div>
    </div>

    <!-- 위치정보
    <div class="hotelAddress">
        <h3>위치정보</h3>
        <hr>
        <div class="adApi">
            <input type="text" v-model="postcode" id="postcode" placeholder="우편번호">
            <input type="button" @click="execDaumPostcode()" value="우편번호 찾기"><br>
            <input type="text" v-model="address" id="address" placeholder="주소"><br>
            <input type="text" v-model="detailAddress" id="detailAddress" placeholder="상세주소">
            <input type="text" v-model="extraAddress" id="extraAddress" placeholder="참고항목">
        </div>
    </div> -->

    <!-- 이미지 -->
    <div class="hotelImg">
        <h3>이미지</h3>
        <hr>
        <p class="hotelImgLabel">* 숙소이미지</p>
    
    <div v-if="this.files.length < 9">
        <input type="file" id="files" ref="files" 
                        multiple v-on:change="handleFilesUpload()" hidden />
        <v-btn @click="chooseFile"  class="vbtn">
            이미지 업로드
        </v-btn>
        <span>최대 9장까지 등록 가능합니다.</span>
    </div>

    <div v-else class="cancelFile">
        <v-btn @click="cancelFile">
            전체 취소
        </v-btn> 
    </div>

    <div>
         <table>
            <tr>
                <td v-for="(none, index) in notImage" :key="index" > 
                    <div v-if="files[index] == null">
                        <v-icon>
                            mdi-image
                        </v-icon>
                    </div>
                    <div v-else>
                         <img :src="files[index].preview" class="preview" width="100px" height="100px"/>
                         <v-icon @click="imgCancel(index)">
                            mdi-close
                        </v-icon>
                    </div>
                </td>
            </tr>

        </table>
    </div>
    </div>
    
   <v-btn type="submit" class="btn1">저장하기</v-btn>
    <router-link :to="{ name: 'HotelReadPage',
                                    params: { hotelNo: hotel.hotelNo.toString() } }">
                    취소
                </router-link>

</form>
</template>

<script>
export default {
name: 'HotelModifyForm',
props: {
    hotel: {
        type: Object,
        required: true
    }
},
data () {
    return {
        hotelName: '',
        //hotelInfo: [],
        /* files: [],
        notImage: ['','','','','','','','',''],
        fileNum: 0, */
    }
},
methods: {
    onSubmit () {
        const { hotelName, /*hotelInfo,  files, notImage, fileNum */ } = this
        this.$emit('submit', { hotelName, /*hotelInfo,  files, notImage, fileNum */ })
    }
},
created () {
    this.hotelName = this.hotel.hotelName
    //this.hotelInfo = this.hotelInfo
    /*this.files = this.files
    this.notImage = this.notImage
    this.fileNum = this. fileNum*/
}
}
</script>

<style scoped>
form {
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
input[id="postcode"] {
    width: 200px;
    height: 30px;
    padding: 0px 10px 0px 10px;
    margin-right: 20px;
    font-size: 13px;
    border-radius: 2pt;
    box-shadow: 0 0 0 1pt grey;
    outline: none;
}
input[id="address"] {
    width: 700px;
    height: 30px;
    padding: 0px 10px;
    font-size: 13px;
    border-radius: 2pt;
    box-shadow: 0 0 0 1pt grey;
    outline: none;
}
input[id="detailAddress"] {
    width: 300px;
    height: 30px;
    padding: 0px 10px;
    font-size: 13px;
    border-radius: 2pt;
    box-shadow: 0 0 0 1pt grey;
    outline: none;
}
input[id="extraAddress"] {
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
    margin: 50px 50px 10px 50px;
}
.hotelImgLabel  {
    font-size: 14px;
    position: relative;
    left: 50px;
    top: 30px;
}
.btn1 {
    margin-left: 40%;
    margin-bottom: 30px;
    text-align: center;
    word-spacing: 15px;
    border: none;
    border-radius: 10px;
    padding: 10px 35px;
    text-decoration: none;
    display: inline-block;
    font-size: 15px;
    cursor: pointer;
}
.btn2 {
    margin-left: 10px;
    margin-bottom: 30px;
    text-align: center;
    word-spacing: 15px;
    border: none;
    border-radius: 10px;
    padding: 10px 35px;
    text-decoration: none;
    display: inline-block;
    font-size: 15px;
    cursor: pointer;
}
.vbtn {
    position: relative;
    left: 86%;
    bottom: 5px;
}
.cancelFile {
    position: relative;
    left: 87%;
    bottom: 5px;
}
table {
    position: relative;
    bottom: 50px;
    left: 140px;
    border-collapse: separate;
    border-spacing: 10px;
}
td {
    border: 1px solid black;
    width: 100px;
    height: 100px;
    text-align: center;
}
#files {
    margin: 30px;
}
span {
    position: relative;
    left: 77%;
    top: 30px;
    font-size: 12px;
}
</style>