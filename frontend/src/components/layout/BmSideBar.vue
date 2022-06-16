<template>
<!-- 사업자 전용 페이지 사이드바 입니다. -->
    <v-navigation-drawer app fixed permanent :width="250">
        <ul>
            <li><router-link to="">로그아웃</router-link></li>
            <li><router-link to="">비밀번호 변경</router-link></li>
        </ul>
    </v-navigation-drawer>
</template>

<script>
export default {
    name: 'BmSideBar'
}
</script>

<style scoped>
li {
    float: left;
    list-style:none;
}
a {
  text-decoration: none;
}
</style>