export default {
    IS_LOGGEDIN(state){
        state.isLoggedIn = true
    },
    NOT_LOGGEDIN(state){
        state.isLoggedIn = false
    },
    SET_USER(state, user){
        state.user = user
    }
}