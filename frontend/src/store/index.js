import Vue from 'vue'
import Vuex from 'vuex'

<<<<<<< HEAD
=======
//import createPersistedState from 'vuex-persistedstate'

>>>>>>> 67e3d113041979b3459d984721929f3756e001a6
import state from './states'
import actions from './actions'
import mutations from './mutations'
import getters from './getters'

Vue.use(Vuex)

//const plugins= [createPersistedState({
 //   paths: []
//})]

export default new Vuex.Store({
  state,
  actions,
  mutations,
<<<<<<< HEAD
  getters
=======
  getters,
 // plugins
>>>>>>> 67e3d113041979b3459d984721929f3756e001a6
})
