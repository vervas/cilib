/*
 * Copyright (C) 2003 - 2008
 * Computational Intelligence Research Group (CIRG@UP)
 * Department of Computer Science
 * University of Pretoria
 * South Africa
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */
package net.sourceforge.cilib.games.game.scoring;

import net.sourceforge.cilib.games.game.Game;
import net.sourceforge.cilib.games.result.AbstractGameResult;
import net.sourceforge.cilib.games.result.DrawResult;
import net.sourceforge.cilib.games.result.WinGameResult;
import net.sourceforge.cilib.problem.MaximisationFitness;

/**
 * @author leo
 * This class assigns a fitness based upon the win/lose/draw result of the game and a value assosiated with each outcome
 */
public class WinLoseDrawValueScoringStrategy extends GameScoringStrategy {
    Double winValue;
    Double loseValue;
    Double drawValue;
    /**
     *
     */
    public WinLoseDrawValueScoringStrategy() {
        // TODO Auto-generated constructor stub
        winValue = 1.0;
        loseValue = -2.0;
        drawValue = 0.0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void assignPlayerScores(Game game) {
        // TODO Auto-generated method stub
        AbstractGameResult result = game.getGameResult();
        if(result instanceof DrawResult){
            for(int i = 0; i < game.amPlayers(); ++i)
                game.assignPlayerScore(i, new MaximisationFitness(drawValue));
        }
        else{
            int winnerID = ((WinGameResult)result).getWinner();
            game.assignPlayerScore(winnerID, new MaximisationFitness(winValue));
            for(int i = 1; i <= game.amPlayers(); ++i)
                if(i != winnerID)
                    game.assignPlayerScore(i, new MaximisationFitness(loseValue));
        }
    }

    public Double getDrawValue() {
        return drawValue;
    }

    public void setDrawValue(Double drawValue) {
        this.drawValue = drawValue;
    }

    public Double getLoseValue() {
        return loseValue;
    }

    public void setLoseValue(Double loseValue) {
        this.loseValue = loseValue;
    }

    public Double getWinValue() {
        return winValue;
    }

    public void setWinValue(Double winValue) {
        this.winValue = winValue;
    }

}
