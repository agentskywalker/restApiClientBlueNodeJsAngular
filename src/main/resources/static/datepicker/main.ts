import './polyfills';

import {platformBrowserDynamic} from '@angular/platform-browser-dynamic';

import {NgbdDatepickerPopupModule} from './app/datepicker-popup.module';

platformBrowserDynamic()
    .bootstrapModule(NgbdDatepickerPopupModule)
    .then(ref => {
        // Ensure Angular destroys itself on hot reloads.
        if (window['ngRef']) {
            window['ngRef'].destroy();
        }
        window['ngRef'] = ref;

        // Otherwise, log the boot error
    })
    .catch(err => console.error(err));
