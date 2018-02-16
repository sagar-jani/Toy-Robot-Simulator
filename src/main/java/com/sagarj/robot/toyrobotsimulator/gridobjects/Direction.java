package com.sagarj.robot.toyrobotsimulator.gridobjects;

public enum Direction {

    NORTH(0, 1) {
        @Override
        public Direction left() {
            return WEST;
        }

        @Override
        public Direction right() {
            return EAST;
        }
    },

    SOUTH(0, -1) {
        @Override
        public Direction right() {
            return WEST;
        }

        @Override
        public Direction left() {
            return EAST;
        }
    },

    EAST(1, 0) {
        @Override
        public Direction right() {
            return SOUTH;
        }

        @Override
        public Direction left() {
            return NORTH;
        }
    },

    WEST(-1, 0) {
        @Override
        public Direction right() {
            return NORTH;
        }

        @Override
        public Direction left() {
            return SOUTH;
        }
    };

    private final int stepSizeOnXAxis;
    private final int stepSizeOnYAxis;

    Direction(final int stepSizeOnXAxis, final int stepSizeOnYAxis) {
        this.stepSizeOnXAxis = stepSizeOnXAxis;
        this.stepSizeOnYAxis = stepSizeOnYAxis;
    }

    public abstract Direction right();

    public abstract Direction left();

    public int stepSizeForXAxis() {
        return this.stepSizeOnXAxis;
    }

    public int stepSizeForYAxis() {
        return this.stepSizeOnYAxis;
    }

}
