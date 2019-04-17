const store = new Vuex.Store({
    state: {
        idToken:"a sample id token"
    },
    getters: {
        returnToken: state => {
            return state.idToken
        }
    }
})