<template>
  <v-container>
    <br /><br /><br />
    <form @submit.prevent="onSubmit" class="right">
      <div class="form-group row">
        <label for="staticEmail" class="col-sm-2 col-form-label">이름</label>
        <div class="col-sm-10">
          <p>{{ userInfo.name }}</p>
          <input
            type="email"
            class="form-control"
            id="exampleInputEmail1"
            aria-describedby="emailHelp"
            placeholder="이름"
          />
        </div>
      </div>
      <br />
      <div class="form-group row">
        <label for="staticEmail" class="col-sm-2 col-form-label">이메일</label>
        <div class="col-sm-10">
          <p>{{ userInfo.email }}</p>
          <input
            type="email"
            class="form-control"
            id="exampleInputEmail1"
            aria-describedby="emailHelp"
            placeholder="이메일"
          />
        </div>
      </div>
      <br />
      <br />
      <div class="form-group row">
        <label
          for="staticEmail"
          class="col-sm-2 col-form-label"
          style="font-size: 12px"
          >비밀번호 변경</label
        >
        <div class="col-sm-10">
          <input
            type="password"
            class="form-control"
            id="exampleInputEmail1"
            aria-describedby="emailHelp"
            placeholder="변경할 비밀번호"
            v-model="password"
          />
          <v-btn @click="updatePassword">비밀번호변경</v-btn>
        </div>
      </div>
      <br />
      <br />
      <br />
      <br />
      <h6>사진 이미지 미리보기</h6>

      <div class="form-group">
        <label for="formFile" class="form-label mt-4">이미지 추가/변경</label>
        <input type="file" id="formFile" ref="chooseFiles" accept="image/*" style="display: none;" @change="selectFile"/>
        <v-btn @click="$refs.chooseFiles.click()">파일선택</v-btn>
      </div>
      <img :src="preview">
      <br />
      <br />
      <br />
      <br />

      <v-btn
        class="btn2"
        color="black"
        text
        type="submit"
        width="260"
        style="text-align: center; margin: 0 0 0 18%"
        @click="saveProfileImage"
      >
        저장하기</v-btn
      >
      
      <div>
        <p>{{userInfo.profile_path}}</p>
        <img :src="require(`@/assets/img/${userInfo.profile_path}`)">
      </div>
      
    </form>
  </v-container>
</template>

<script>
import axios from 'axios';
export default {
  name: "MyPageForm",
  props: ["userInfo"],
  data() {
    return {
      password: "",
      preview: [],
      file: '',
      profile_path: this.userInfo.profile_path
    };
  },
  methods: {
    updatePassword() {
      this.$emit("updatePassword", this.password);
    },
    selectFile(e){
      this.file = e.target.files[0]
      this.preview = URL.createObjectURL(this.file)
    },
    saveProfileImage(){
      let formData = new FormData()
      formData.append('multipartFile', this.file)
      axios.post('http://localhost:7777/changeProfileImage', formData, {
        headers: {
                    'Content-Type': 'multipart/form-data'
                }})
      .then(() => console.log('통신성공'))
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
