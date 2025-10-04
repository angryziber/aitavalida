<script lang="ts">
  import {lang, langs, changeLang} from 'i18n'
  import SelectField from './SelectField.svelte'

  export let onChange: (newLang: string) => any = function(newLang) {
    changeLang(newLang)
  }
</script>

<label for="lang" hidden>Language</label>
<SelectField id="lang" class="w-16 {$$props.class ?? ''}" value={lang} options={langs.indexBy(l => l, l => l)} onchange={(e: FormEvent) => onChange(e.currentTarget.value)}/>
