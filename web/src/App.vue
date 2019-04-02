<template>
    <div id="app">
        <router-view @authenticated="setAuthenticated"/>
    </div>
</template>

<script>
    export default {
        name: 'app',
        data() {
            return {
                authenticated: false,
                mockAccount: {
                    username: "user",
                    password: "pass"
                }
            }
        },
        mounted() {
            if (!localStorage.authenticated) {
                this.$router.replace({name: "landing"})
            }
        },
        methods: {
            setAuthenticated(status) {
                this.authenticated = status;
            },
        }
    }
</script>

<style>
    * {
        box-sizing: border-box;
        margin: 0;
        padding: 0;
    }
    body {
        font-family: Arial, Helvetica, sans-serif;
        line-height: 1.4;
        color: white;
    }
    .btn {
        display: inline-block;
        border: none;
        background: #555;
        color: #fff;
        padding: 7px 20px;
        cursor: pointer;
    }
    .btn:hover {
        background: #666;
    }
    [v-cloak] {
        display: none;
    }
</style>