package com.gpl.rpg.AndorsTrail_beta.controller.listeners;

import com.gpl.rpg.AndorsTrail_beta.model.ability.ActorCondition;
import com.gpl.rpg.AndorsTrail_beta.model.actor.Actor;

public interface ActorConditionListener {
	public void onActorConditionAdded(Actor actor, ActorCondition condition);
	public void onActorConditionRemoved(Actor actor, ActorCondition condition);
	public void onActorConditionDurationChanged(Actor actor, ActorCondition condition);
	public void onActorConditionMagnitudeChanged(Actor actor, ActorCondition condition);
	public void onActorConditionRoundEffectApplied(Actor actor, ActorCondition condition);
	public void onActorConditionImmunityAdded(Actor actor, ActorCondition condition);
	public void onActorConditionImmunityRemoved(Actor actor, ActorCondition condition);
	public void onActorConditionImmunityDurationChanged(Actor actor, ActorCondition condition);
}
