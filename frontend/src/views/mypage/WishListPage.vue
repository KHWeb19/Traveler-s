<template>
  <div align="center">
    <v-container>
      <table style="width: 800px;">
        <tr>
          <td align="left">
            <h2 class="pageTit">위시리스트</h2>            
          </td>
        </tr>

        <tr>
          <td align="left">
            <span class="page-count">전체</span>
          </td>
        </tr>

        <tr>
          <td align="center">
            <my-page-wish :wishLists="wishLists"></my-page-wish>
          </td>
        </tr>
      </table>
    </v-container>
  </div>
</template>

<script>
import MyPageWish from "@/components/mypage/MyPageWish.vue";
import { mapActions, mapState } from "vuex";
export default {
  name: "WishListPage",
  components: { MyPageWish },
  computed: {
    ...mapState(["user", "wishLists"]),
  },
  methods: {
    ...mapActions(["setUser", "fetchWishLists"]),
  },
  mounted() {
    this.setUser();
    this.fetchWishLists();
  },
};
</script>

<style>
div {
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
}
h2 {
  padding: 50px 0px 30px 0px;
}
.pageTit {
  padding: 50px 0px 30px 0px;
  font-family: 'NanumSquareRound';
  font-size: 2.0rem;
  line-height: 1.25;
  letter-spacing: -.01em;
  color: #202020;
  font-weight: 900;
}
.pageTit:after {
    content: '';
    display: inline-block;
    width: 4px;
    height: 4px;
    margin-bottom: 24px;
    border-radius: 50%;
    background-color: #e63668;
}
.page-count {
  margin-left: 15px;
  border: 1px;
  border-bottom: 5px solid #e63668;
  border-radius: 5px;
  padding: 5px 10px;
  outline: none;
  color: #18225c;
  -webkit-text-stroke: 0.7px #18225c;
}
.btn {
  position: sticky;
  left: 90%;
  text-decoration: none;
}
/*table, th, td{
    border-collapse:collapse;
    border: 1px solid black;
}*/
</style>
