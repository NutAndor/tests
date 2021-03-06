package com.gpl.rpg.AndorsTrail_beta.controller.listeners;

import com.gpl.rpg.AndorsTrail_beta.model.ability.ActorCondition;
import com.gpl.rpg.AndorsTrail_beta.model.actor.Actor;
import com.gpl.rpg.AndorsTrail_beta.util.ListOfListeners;

public final class ActorConditionListeners extends ListOfListeners<ActorConditionListener> implements ActorConditionListener {

	private final Function2<ActorConditionListener, Actor, ActorCondition> onActorConditionAdded = new Function2<ActorConditionListener, Actor, ActorCondition>() {
		@Override public void call(ActorConditionListener listener, Actor actor, ActorCondition condition) { listener.onActorConditionAdded(actor, condition); }
	};
	private final Function2<ActorConditionListener, Actor, ActorCondition> onActorConditionRemoved = new Function2<ActorConditionListener, Actor, ActorCondition>() {
		@Override public void call(ActorConditionListener listener, Actor actor, ActorCondition condition) { listener.onActorConditionRemoved(actor, condition); }
	};
	private final Function2<ActorConditionListener, Actor, ActorCondition> onActorConditionDurationChanged = new Function2<ActorConditionListener, Actor, ActorCondition>() {
		@Override public void call(ActorConditionListener listener, Actor actor, ActorCondition condition) { listener.onActorConditionDurationChanged(actor, condition); }
	};
	private final Function2<ActorConditionListener, Actor, ActorCondition> onActorConditionMagnitudeChanged = new Function2<ActorConditionListener, Actor, ActorCondition>() {
		@Override public void call(ActorConditionListener listener, Actor actor, ActorCondition condition) { listener.onActorConditionMagnitudeChanged(actor, condition); }
	};
	private final Function2<ActorConditionListener, Actor, ActorCondition> onActorConditionRoundEffectApplied = new Function2<ActorConditionListener, Actor, ActorCondition>() {
		@Override public void call(ActorConditionListener listener, Actor actor, ActorCondition condition) { listener.onActorConditionRoundEffectApplied(actor, condition); }
	};
	private final Function2<ActorConditionListener, Actor, ActorCondition> onActorConditionImmunityAdded = new Function2<ActorConditionListener, Actor, ActorCondition>() {
		@Override public void call(ActorConditionListener listener, Actor actor, ActorCondition condition) { listener.onActorConditionImmunityAdded(actor, condition); }
	};
	private final Function2<ActorConditionListener, Actor, ActorCondition> onActorConditionImmunityRemoved = new Function2<ActorConditionListener, Actor, ActorCondition>() {
		@Override public void call(ActorConditionListener listener, Actor actor, ActorCondition condition) { listener.onActorConditionImmunityRemoved(actor, condition); }
	};
	private final Function2<ActorConditionListener, Actor, ActorCondition> onActorConditionImmunityDurationChanged = new Function2<ActorConditionListener, Actor, ActorCondition>() {
		@Override public void call(ActorConditionListener listener, Actor actor, ActorCondition condition) { listener.onActorConditionImmunityDurationChanged(actor, condition); }
	};
	
	@Override
	public void onActorConditionAdded(Actor actor, ActorCondition condition) {
		callAllListeners(this.onActorConditionAdded, actor, condition);
	}

	@Override
	public void onActorConditionRemoved(Actor actor, ActorCondition condition) {
		callAllListeners(this.onActorConditionRemoved, actor, condition);
	}

	@Override
	public void onActorConditionDurationChanged(Actor actor, ActorCondition condition) {
		callAllListeners(this.onActorConditionDurationChanged, actor, condition);
	}

	@Override
	public void onActorConditionMagnitudeChanged(Actor actor, ActorCondition condition) {
		callAllListeners(this.onActorConditionMagnitudeChanged, actor, condition);
	}

	@Override
	public void onActorConditionRoundEffectApplied(Actor actor, ActorCondition condition) {
		callAllListeners(this.onActorConditionRoundEffectApplied, actor, condition);
	}
	

	@Override
	public void onActorConditionImmunityAdded(Actor actor, ActorCondition condition) {
		callAllListeners(this.onActorConditionImmunityAdded, actor, condition);
	}

	@Override
	public void onActorConditionImmunityRemoved(Actor actor, ActorCondition condition) {
		callAllListeners(this.onActorConditionImmunityRemoved, actor, condition);
	}

	@Override
	public void onActorConditionImmunityDurationChanged(Actor actor, ActorCondition condition) {
		callAllListeners(this.onActorConditionImmunityDurationChanged, actor, condition);
	}
}
