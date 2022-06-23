<template>
    <form @submit.prevent="onSubmit">

    <!-- 기본정보 -->
    <div class="hotelName">
        <h3>기본정보</h3>
        <p class="hotelNameP">*은 필수 입력사항입니다.</p>
        <hr>
        <label class="hotelNameLabel">* 숙소명</label>
        <input type="text" class="hotelNameBox" v-model="hotelName" placeholder="숙소명을 입력해주세요."/><br>
        <label class="hotelIntroLabel">소개</label>
        <input type="text" class="hotelIntroBox" v-model="hotelIntro" placeholder="소개글을 입력해주세요."/>
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
    <router-link :to="{ name: 'HotelListPage' }" ><v-btn class="btn2">취소</v-btn></router-link>

</form>
</template>

<script>
export default {
    name: 'HotelRegisterForm',
    props: {
        user: {
            type: Object,
            require: true,
        },
    },
    data () {
        return {
            hotelName: '',
            hotelInfo: [],
            hotelIntro: '',
            postcode: '',
            address: '',
            detailAddress: '',
            extraAddress: '',
            files: [],
            notImage: ['','','','','','','','',''],
            fileNum: 0,
            totalAddress:''

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
            if(this.files.length < 5){
                alert('사진은 5장 이상 첨부해주세요')
            }else{
                const { hotelName, hotelInfo, hotelIntro, postcode, address, detailAddress, extraAddress, files, writer } = this
                this.totalAddress = address + detailAddress + extraAddress
                const { totalAddress} = this
                this.$emit('submit', { hotelName, hotelInfo, hotelIntro, postcode, totalAddress ,files ,writer })
            }
        },
           handleFilesUpload () {
            if(this.$refs.files.files.length > 9){
                alert("최대 9장 까지 가능 합니다")
                this.$refs.files.value = ''
                return
            }

            this.fileNum += this.$refs.files.files.length
            console.log(this.fileNum)
            if(this.fileNum < 10){
                        for (let i = 0; i < this.$refs.files.files.length; i++) {
                            this.files = [
                                ...this.files,
                                {
                                    file: this.$refs.files.files[i],
                                    preview: URL.createObjectURL(this.$refs.files.files[i])
                                }
                            ]
                        }      
                     
            }else{
                alert("최대 9장 까지 가능 합니다")
                console.log(this.fileNum)
                this.fileNum -= this.$refs.files.files.length
                this.$refs.files.value = ''
            }  
            
           },
          /* handleFileUpload () {
            //this.$refs.files2[0].files 는 배열의 상태여서 그랬던거 같음
            //파일 추가하고 또 버튼 눌러서 추가할때마다 files객체 생기는듯
            console.log(this.$refs.files2)
                console.log(this.$refs.files2[0].files[0])
                this.files = [
                            ...this.files,
                                {
                                    file: this.$refs.files2[0].files[0],
                                    preview: URL.createObjectURL(this.$refs.files2[0].files[0]),
                                }
                            ]
                        console.log(this.files)
                
           },*/
    
        chooseFile() {
              document.getElementById("files").click()
        },
        cancelFile() {
            this.files = ''
            this.fileNum = 0
        },
        imgCancel(index) {
            //인덱스 어디부터 하나 삭제
            this.files.splice(index,1)
            this.fileNum -= 1
            console.log(this.files)
        }
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
.hotelIntroLabel {
    font-size: 14px;
    margin-left: 50px;
}
.hotelIntroBox, .hotelIntroBox:focus {
    width: 800px;
    padding: 5px 8px;
    margin: 30px 0px 0px 30px;
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