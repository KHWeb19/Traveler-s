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
            <input type="checkbox" name="hotelinfo" v-model="hotelInfo" value="oceanView">오션뷰
        </label>
        <label>
            <input type="checkbox" name="hotelinfo" v-model="hotelInfo" value="terrace">테라스
        </label>
        <label>
            <input type="checkbox" name="hotelinfo" v-model="hotelInfo" value="swimmingPool">수영장
        </label>
        <label>
            <input type="checkbox" name="hotelinfo" v-model="hotelInfo" value="carCharge">전기차충전
        </label>
        <label>
            <input type="checkbox" name="hotelinfo" v-model="hotelInfo" value="nearAirport">공항근처
        </label>
        <label>
            <input type="checkbox" name="hotelinfo" v-model="hotelInfo" value="golfCourse">골프장
        </label>
        <label>
            <input type="checkbox" name="hotelinfo" v-model="hotelInfo" value="freeParking">무료주차
        </label>
        <label>
            <input type="checkbox" name="hotelinfo" v-model="hotelInfo" value="bbqGrill">바베큐그릴
        </label>
        <label>
            <input type="checkbox" name="hotelinfo" v-model="hotelInfo" value="pet">반려동물
        </label>
        <label>
            <input type="checkbox" name="hotelinfo" v-model="hotelInfo" value="spa">온천
        </label>
        </div>
    </div>

    <!-- 위치정보 -->
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
    </div>

    <!-- 이미지 -->
    <div class="hotelImg">
        <h3>이미지</h3>
        <hr>
        <p class="hotelImgLabel">* 숙소이미지</p>
    </div>
 
    <div>
         <table>
            <tr>
                <td v-for="(none, index) in notImage" :key="index" > 
                    <div v-if="files[index] == null">
                    <input  type="file" id="fileUpload" ref="files" 
                         v-on:change="handleFileUpload()" hidden />
                    <v-icon @click="chooseFile">
                        mdi-image
                    </v-icon> 
                    </div>
                    <div v-else class="image-frame">
                         <img  :src="files[index].preview" class="preview" width="200px" height="200px"/>
                         <v-icon @click="imgCancel(index)">
                            mdi-close
                        </v-icon>
                    </div>
                </td>
            </tr>

        </table>
    </div>
    
 
   <div>
        <input type="file" id="files" ref="files" 
                            multiple v-on:change="handleFileUpload()"/>
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
    data () {
        return {
            hotelName: '',
            hotelInfo: [],
            postcode: '',
            address: '',
            detailAddress: '',
            extraAddress: '',
            files: [],
            filesPreview:[],
            notImage: ['','','','','','','','','']
        
        }
    },
    methods: {
        execDaumPostcode() {
      new window.daum.Postcode({
        oncomplete: (data) => {
          if (this.extraAddress !== "") {
            this.extraAddress = "";
          }
          if (data.userSelectedType === "R") {
            // 사용자가 도로명 주소를 선택했을 경우
            this.address = data.roadAddress;
          } else {
            // 사용자가 지번 주소를 선택했을 경우(J)
            this.address = data.jibunAddress;
          }
 
          // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
          if (data.userSelectedType === "R") {
            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
            if (data.bname !== "" && /[동|로|가]$/g.test(data.bname)) {
              this.extraAddress += data.bname;
            }
            // 건물명이 있고, 공동주택일 경우 추가한다.
            if (data.buildingName !== "" && data.apartment === "Y") {
              this.extraAddress +=
                this.extraAddress !== ""
                  ? `, ${data.buildingName}`
                  : data.buildingName;
            }
            // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
            if (this.extraAddress !== "") {
              this.extraAddress = `(${this.extraAddress})`;
            }
          } else {
            this.extraAddress = "";
          }
          // 우편번호를 입력한다.
          this.postcode = data.zonecode;
        },
      }).open();
         },
        onSubmit () {
           
            this.files = this.$refs.files.files
            console.log(this.files[0])
            const { hotelName, hotelInfo, postcode, address, detailAddress, extraAddress, files } = this
            
            this.$emit('submit', { hotelName, hotelInfo, postcode, address, detailAddress, extraAddress, files })
        },
           handleFileUpload () {
            console.log(this.$refs.files.files)
                        for (let i = 0; i < this.$refs.files.files; i++) {
                            this.files = [
                                ...this.files,
                                {
                                    file: this.$refs.files.files[i],
                                    preview: URL.createObjectURL(this.$refs.files.files[i]),
                                }
                            ];
                        }  
                        
           },
    
        chooseFile() {
              document.getElementById("fileUpload").click()
        },
        imgCancel(index) {
            this.files.splice(index,1)
        }   
        
    }
 
}
</script>

<style scoped>
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
table {
    margin-left: auto;
    margin-right: auto;
    border-collapse: separate;
    border-spacing: 10px;
}

td {
    border: 1px solid black;
    width: 200px;
    height: 200px;
    text-align: center;
    
}
.preview {
    width: 100%;
}
.image1{
    background-image: url('@/assets/hotel.jpg');

}
image-frame{
     padding: 0 !important;
}
</style>