<template>
  <v-container style="padding: 0px; margin-top: 20px">
    <v-col class="mypage" outlined>
      <div style="display: flex;">
        <v-form class="pageBox" ref="form" lazy-validation>
          <v-col class="pageTit">마이 페이지</v-col>
          <v-col>
            <v-col>
              <v-img v-if="userInfo.profile_path" :src="require(`@/assets/img/${this.userInfo.profile_path}`)"
                class="proimg" />
            </v-col>
            <table class="middle">
              <tr>
                <td class="subject">
                  이름
                </td>
                <div class="profileName" type="text">
                  {{ userInfo.name }}
                </div>
              </tr>
              <tr>
                <td class="subject">
                  이메일
                </td>
                <div class="profileEmail" type="text">
                  {{ userInfo.email }}
                </div>
              </tr>
              <tr>
                <td class="subject">
                  비밀번호 변경
                </td>
                <td class="profileMiddle">
                  <v-text-field class="inputfield" type="password" v-model="password" :rules="passwordRules" />
                </td>
                <td>
                  <v-btn class="primary" width="70px" id="btn1" @click="updatePassword">
                    변경
                  </v-btn>
                </td>
              </tr>
            </table>
          </v-col>
          <v-col>
            <v-col class="imgCardTitle">
              <v-col class="subTit">이미지 추가/변경</v-col>
            </v-col>
            <v-card class="cardBox">
              <v-card-text class="imgChangeTxt" style="text-align: right; padding-right: 10px">
                이미지 미리보기
              </v-card-text>
              <img :src="preview" style="width: 200px; text-align: center;" />
              <input type="file" class="imgChange" ref="chooseFiles" accept="image/*" style="display: none"
                @change="selectFile" />
              <v-col>
                <v-btn class="primary" @click="$refs.chooseFiles.click()">파일선택</v-btn>
              </v-col>
            </v-card>
            <div style="text-align: center; padding-top: 26px">

              <v-btn class="primary" width="300px" text type="submit" @click="saveProfileImage">
                저장하기
              </v-btn>
            </div>

          </v-col>
        </v-form>
      </div>
    </v-col>
  </v-container>
</template>

<script>
import axios from "axios";
import router from "@/router";

export default {
  name: "MyPageForm",
  props: { userInfo: Object },
  data() {
    return {
      password: "",
      preview: [],

      file: "",
      profile_path: this.userInfo.profile_path,
      memberName: this.userInfo.name,
      memberEmail: this.userInfo.email,

      passwordRules: [
        (v) => !!v || "비밀번호를 작성해주세요.",
        (v) => /^[a-zA-Z0-9]*$/.test(v) || "영문+숫자로만 입력해주세요",
        (v) => /(?=.*[0-9])(?=.*[a-zA-ZS])/.test(v) || "영문+숫자를 섞어주세요",
        (v) => !(v && v.length < 8) || "8자리이상으로해주세요",
        (v) => !(v && v.length > 15) || "15자리를 넘길수없습니다.",
      ],
    };
  },
  methods: {
    updatePassword() {
      if (this.$refs.form.validate()) {
        this.$emit("updatePassword", this.password);
      }
    },
    selectFile(e) {
      this.file = e.target.files[0];
      this.preview = URL.createObjectURL(this.file);
    },

    saveProfileImage() {
      let formData = new FormData();
      formData.append("multipartFile", this.file);
      axios
        .post("http://localhost:7777/changeProfileImage", formData, {
          headers: {
            "Content-Type": "multipart/form-data",
          },
        })
        .then(() => {
          console.log("통신성공");
          router.push("/");
        });
    },
    management() {
      alert("권한이 없습니다.");
    },
  },
};
</script>

<style scoped>
.proimg {
  width: 200px;
  height: 200px;
  text-align: right;
  margin-left: auto;
  margin-right: auto;
  border-radius: 70%;
}

.btn2 {
  color: #18225c;
  width: 260px;
  text-align: center;
}

.mypage {
  width: 600px;
  height: outo;
  background: white;
  margin: 50px 0px 0px;
}

ul a {
  color: inherit;
}

ul {
  list-style: none;
  margin: 20% 0 0 0;
}

tr {
  width: 250px;
  height: 80px;
}

td {
  width: 200px;
  height: 80px;
  padding: 0 10px;
}

.pageBox {
  width: 600px;
  height: auto;
}

.pageTit {
  margin: 50px 0px 30px 0px;
  font-family: 'NanumSquareRound';
  font-size: 2.0rem;
  line-height: 1.25;
  letter-spacing: -.01em;
  color: #202020;
  font-weight: 900;
}

.subTit {
  margin: 0px 0px 10px;
  font-family: 'NanumSquareRound';
  font-size: 1.4rem;
  line-height: 1.25;
  letter-spacing: -.01em;
  color: #202020;
  font-weight: 900;
}

.profileName {
  text-align: left;
  border: #404040;
  width: 255px;
  height: 35px;
  padding: 0%;
  margin: 28px 0 17px 20px;
  border: 0 0 1px black;
}

.profileEmail {
  text-align: left;
  width: 255px;
  height: 35px;
  margin: 28px 0 17px 20px;
}

.changePW {
  width: 200px;
  height: 35px;
}

inputfield {
  width: 200px;
  height: 35px;
}

.subject {
  text-align: right;
  width: 300px;
}

.profileMiddle {
  width: 250px;
  height: 80px;
}

.allbtn {
  text-decoration: none;
  color: #404040;
  font-weight: 600;
  font-size: 15px;
  line-height: 29px;
  width: 70px;
  height: 50px;
}

.primary {
  color: #1d68dc;
  height: 48px;
}

.middle {
  width: 100%;
}

.imgChangeTxt {
  width: 100%;
  height: 50px;
}

.imgCardTitle {
  margin: 0 0 15px;
}

.imgChange {
  width: 200px;
  text-align: center;
}

@media screen and (max-width: 700px) {
  .mypage {
    width: 100vw;
    margin: 10vh 0px 0px;
  }

  .proimg {
    width: 30vw;
    min-width: 100px;
    height: 30vw;
    min-height: 100px;
    text-align: right;
    margin-left: auto;
    margin-right: auto;
    border-radius: 70%;
  }

  table {
    font-size: 0.8em;
  }

  .profileMiddle {
    width: 200px;
    height: 80px;
  }

  .profileEmail {
    text-align: center;
    width: 200px;
    height: 35px;
    margin: 28px 0 17px 15px;
  }

  .profileName {
    text-align: center;
    border: #404040;
    width: 200px;
    height: 35px;
    padding: 0%;
    margin: 28px 0 17px 15px;
    border: 0 0 1px black;
  }

  .imgChange {
    width: 25vw;
    height: 25vw;
  }

  .cardBox {
    width: 85vw;
  }
}
</style>
