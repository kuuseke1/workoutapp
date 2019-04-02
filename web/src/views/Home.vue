<template>
    <div>
        <Navigation activeTab="Home"/>
        <p>Tere Tulemast, User!!! :D</p>
    </div>

</template>

<script>
    import Navigation from '../components/Navigation.vue';
    import AddExercise from "../views/AddExercise";
    import axios from "axios"
    export default {
        name: "Home",
        components: {
            AddExercise,
            Navigation
        }
    }
</script>

<style scoped>
</style>