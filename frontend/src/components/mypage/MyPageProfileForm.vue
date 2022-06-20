<template>
  <v-container>
    <br /><br /><br />

    <v-card class="right">
      <div style="display: flex; justify-content: center">
        <form @submit.prevent="onSubmit">
          <table>
            <br />
            <br />
            <tr>
              <td style="text-align: right; padding-right: 10px">이름</td>
              <td>
                <input
                  style="
                    margin: 3px;
                    border: 1px solid #d6d6d6;
                    border-radius: 3px;
                    width: 300px;
                    height: 35px;
                    padding-left: 5px;
                  "
                  type="text"
                  v-model="memberName"
                />
              </td>
            </tr>
            <tr>
              <td></td>
              <td
                style="
                  width: 300px;
                  color: grey;
                  font-size: 12px;
                  padding: 5px 0px 0px 5px;
                "
              ></td>
            </tr>
            <br />
            <tr>
              <td style="text-align: right; padding-right: 10px">이메일</td>
              <td>
                <input
                  style="
                    margin: 3px;
                    border: 1px solid #d6d6d6;
                    border-radius: 3px;
                    width: 300px;
                    height: 35px;
                    padding-left: 5px;
                  "
                  type="text"
                  v-model="memberEmail"
                />
              </td>
            </tr>
            <br />
            <br />
            <tr>
              <td style="text-align: right; padding-right: 10px">
                새 비밀번호
              </td>
              <td>
                <input
                  style="
                    margin: 3px;
                    border: 1px solid #d6d6d6;
                    border-radius: 3px;
                    width: 300px;
                    height: 35px;
                    padding-left: 5px;
                  "
                  type="password"
                  v-model="password"
                />
                <v-btn @click="updatePassword">비밀번호변경</v-btn>
              </td>
            </tr>
            <br />
            <br />
            <br />
            <br />
            <br />
            <h4>사진 이미지 미리보기</h4>
            <tr>
              <td style="text-align: right; padding-right: 10px">
                이미지 추가/변경
              </td>
              <td>
                <input
                  type="file"
                  id="formFile"
                  ref="chooseFiles"
                  accept="image/*"
                  style="display: none"
                  @change="selectFile"
                />
                <v-btn @click="$refs.chooseFiles.click()">파일선택</v-btn>
              </td>
            </tr>
            <br />
            <br />
            <br />

            <img :src="preview" style="width: 200px" />
          </table>
          <div style="text-align: center; padding-top: 26px">
            <br />
            <v-btn
              class="btn2"
              color="black"
              text
              type="submit"
              width="260"
              style="text-align: center"
              @click="saveProfileImage"
            >
              저장하기</v-btn
            >
          </div>
        </form>
      </div>
    </v-card>
  </v-container>
</template>

<script>
import axios from "axios";
export default {
  name: "MyPageForm",
  props: {
    userInfo: {
      type: Object,
      require: true,
    },
  },
  data() {
    return {
      password: "",
      preview: [],
      file: "",
      profile_path: this.userInfo.profile_path,
      memberName: this.userInfo.name,
      memberEmail: this.userInfo.email,
    };
  },
  methods: {
    updatePassword() {
      this.$emit("updatePassword", this.password);
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
        .then(() => console.log("통신성공"));
    },
    management() {
      alert("권한이 없습니다.");
    },
  },
};
</script>

<style scoped>
.left_menu {
  width: 200px;
  height: 848px;
  border-right-width: 3px;
  border-right-color: rgba(64, 64, 64);
  border-right-style: dotted;
  padding: 3%;
  background: rgba(64, 64, 64);
  color: white;
}
.proimg {
  width: 150px;
}

.col1 {
  background: rgb(224, 224, 224);
}
.btn2 {
  background: rgb(224, 224, 224);
}

.right {
  width: 600px;
  height: 848px;
  background: rgb(250, 250, 250);
}

ul a {
  color: inherit;
}

ul {
  list-style: none;
  margin: 20% 0 0 0;
}

a {
  text-decoration: none;
}
</style>
