<script>
import Vue from 'vue'
import cookies from 'vue-cookies'

Vue.use(cookies)

export default {
    name: 'OAuth2Redirect',
    data () {
        return {
            access_token:'',
            refresh_token:''

        }
    },
    mounted () {
        localStorage.setItem("access_token", this.$route.query.access_token)
        this.$cookies.set("refresh_token", this.$route.query.refresh_token)
        const session = this.$cookies.get("SESSION")
        console.log(session)
        this.$cookies.set("SESSION",session,12096000)
        if(localStorage.getItem("access_token") != null){
        this.$router.go(-2)}
    }
}
</script>