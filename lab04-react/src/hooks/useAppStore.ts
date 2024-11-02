import { create } from 'zustand';
import { sessionStore, SessionStore } from './store/session.store';

// Zustand es para proporcionar un estado global, es decir, compartido en todos los componentes sin tener que pasarlo como prop
// Es similar a useContext de react
type AppStore = SessionStore;
export const useAppStore = create<AppStore>(set => ({
	...sessionStore(set),
}));
