<template>
    <div class="topnav">
        <!---<router-link to="/">Home</router-link>
        |
        <router-link to="/about">About</router-link>
        |
        <router-link to="/addPost"> Add exercise</router-link>
        --->
        <router-link :to="{path: '/home'}" :class="{ active: activeTab === 'Home'}" >HOME</router-link>
        <router-link :to="{path: '/addExercise'}" :class="{ active: activeTab === 'AddExercise'}" >ADD EXERCISE</router-link>
    </div>
</template>
<script>
    export default {
        name: "Navigation",
        props: ['activeTab'],
    }
</script>
<style scoped>
    /* Navigation style */
    .topnav {
        background-color: #333;
        color: #fff;
        overflow: hidden;
        text-align: center;
        padding: 10px;
    }
    /* Links inside Nav bar */
    .topnav a {
        float: left;
        text-align: center;
        padding: 14px 16px;
        text-decoration: none;
        font-size: 17px;
        color: #f2f2f2;
    }
    /* When hovering over links */
    .topnav a:hover {
        background-color:black;
        color: #a24444;
    }
    /* Add a color to the active/current link */
    .topnav a.active {
        background-color: #a24444;
        color: black;
    }
</style>