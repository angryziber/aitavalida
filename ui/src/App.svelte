<script lang="ts">
  import {t} from 'i18n'
  import Toasts from 'src/components/Toasts.svelte'
  import {navigate, Route, Router} from 'svelte-routing'
  import Compass from 'src/pages/Compass.svelte'
  import {onMount} from 'svelte'
  import LangSelect from 'src/components/LangSelect.svelte'

  onMount(() => {
    navigate('/tallinn2025')
  })
</script>

<svelte:head>
  <title>{t.title}</title>
</svelte:head>

<Toasts/>

<main class="text-center pt-4">
  <h1 style="font-weight: bold" class="max-sm:max-w-64 mx-auto">{t.title}</h1>
  <div class="absolute top-4 right-4">
    <LangSelect/>
  </div>

  <Router>
    <Route path="/tallinn2025" component={Compass}/>
  </Router>

  <a href="https://github.com/angryziber/aitavalida" target="_blank" class="py-4">Open Source @ GitHub</a>
</main>
