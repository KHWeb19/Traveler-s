<template>
  <div class="myPageForm">
    <h4>MY 페이지</h4>
    <br /><br />
    <div class="left_menu">
      <ul>
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        <li>
          <router-link :to="{ name: '', params: {} }">
            <strong style="text-align: center"> 프로필 </strong>
          </router-link>
        </li>
        <br />
        <br />
        <br />
        <li>
          <router-link :to="{ name: '', params: {} }">
            <strong style="text-align: center"> 위시리스트 </strong>
          </router-link>
        </li>
        <br />
        <br />
        <br />
        <li>
          <router-link :to="{ name: '', params: {} }">
            <strong style="text-align: center"> 예약 내역 확인 </strong>
          </router-link>
        </li>
        <br />
        <br />
        <br />
        <li>
          <router-link :to="{ name: '', params: {} }">
            <strong style="text-align: center" @click="management">
              숙소 관리
            </strong>
          </router-link>
        </li>
      </ul>
    </div>

    <form @submit.prevent="onSubmit">
      <div class="right_content">
        <h4 class="col1">프로필 정보</h4>
        <br />
        <v-container class="inputYourInfo">
          <div>
            <v-text-field
              flat
              v-model="id"
              type="text"
              disabled
              dense
              required
            ></v-text-field>
          </div>
          <v-text-field
            flat
            v-model="name"
            type="text"
            dense
            clearable
            required
            placeholder="이름 변경하기"
          ></v-text-field>
          <br />
          <v-text-field
            flat
            v-model="pw"
            type="password"
            dense
            placeholder="비밀번호 변경하기"
            :rules="rules_pw"
          ></v-text-field>
          <v-text-field
            flat
            v-model="pw1"
            type="password"
            dense
            placeholder="비밀번호 변경 확인"
            :rules="rules_pw1"
          ></v-text-field>
          <br />
          <v-btn
            class="btn2"
            color="black"
            text
            type="submit"
            width="260"
            style="text-align: center; margin: 0 0 0 18%"
          >
            저장하기</v-btn
          >
        </v-container>
      </div>
    </form>
  </div>
</template>

<script>
export default {
  name: "MyPageProfileForm",
  props: {
    memberInfo: {
      type: Object,
      required: true,
    },
  },
  data() {
    return {};
  },
  methods: {
    management() {
      alert("권한이 없습니다.");
    },
  },
};
</script>

<style scoped>
.myPageForm {
  display: grid;
  grid-template-columns: 250px 600px;
}
.left_menu {
  width: 200px;
  height: 800px;
  border-right-width: 3px;
  border-right-color: rgba(64, 64, 64);
  border-right-style: dotted;
  padding: 3%;
  background: rgba(64, 64, 64);
  color: white;
}
.col1 {
  background: rgb(224, 224, 224);
}
.btn2 {
  background: rgb(224, 224, 224);
}

.right_content {
  width: 450px;
  height: 800px;
  background: rgb(250, 250, 250);
  margin: 5% 0 0 25%;
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
