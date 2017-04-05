package ru.digdes.steammarketparser.model.enums;

/**
 * TODO javadoc
 */
public enum ItemQuality {
    COMMON {
        @Override
        public String toString() {
            return "Common";
        }
    },
    UNCOMMON {
        @Override
        public String toString() {
            return "Uncommon";
        }
    },
    RARE {
        @Override
        public String toString() {
            return "Rare";
        }
    },
    MYTHICAL {
        @Override
        public String toString() {
            return "Mythical";
        }
    },
    IMMORTAL {
        @Override
        public String toString() {
            return "Immortal";
        }
    },
    LEGENDARY {
        @Override
        public String toString() {
            return "Legendary";
        }
    },
    ARCANA {
        @Override
        public String toString() {
            return "Arcana";
        }
    },
    ANCIENT {
        @Override
        public String toString() {
            return "Ancient";
        }
    },
}
